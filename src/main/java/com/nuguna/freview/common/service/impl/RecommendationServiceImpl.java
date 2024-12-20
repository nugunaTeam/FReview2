package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.InterestAccumulationDTO;
import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import com.nuguna.freview.common.dto.TopPerformersDTO;
import com.nuguna.freview.common.mapper.InterestAccumulationMapper;
import com.nuguna.freview.common.mapper.RecommendationMapper;
import com.nuguna.freview.common.service.RecommendationService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecommendationServiceImpl implements RecommendationService {

  private final RecommendationMapper recommendationMapper;
  private final InterestAccumulationMapper interestAccumulationMapper;

  @Autowired
  public RecommendationServiceImpl(RecommendationMapper recommendationMapper,
      InterestAccumulationMapper interestAccumulationMapper) {
    this.recommendationMapper = recommendationMapper;
    this.interestAccumulationMapper = interestAccumulationMapper;
  }

  @Override
  public List<RecommendationResponseDTO> getRecommendationUserList(Long previousSeq,
      int limit, String userCode) {
    return recommendationMapper.selectUsers(previousSeq, limit, userCode);
  }

  @Override
  public List<RecommendationResponseDTO> getFilteredRecommendationUserList(
      Long previousSeq, int limit, List<String> foodTypes, List<String> tags, String userCode) {
    return recommendationMapper.filterUsers(previousSeq, limit, foodTypes, tags, userCode);
  }

  @Override
  public List<PersonalizedUserDTO> getPersonalizedRecommendationUsers(Long userSeq,
      String pageCode) {
    try {
      List<PersonalizedUserDTO> recommendations = new ArrayList<>();
      Set<Long> userIds = new HashSet<>();

      List<InterestAccumulationDTO> interests = interestAccumulationMapper.getByUserSeq(userSeq);

      if (interests.isEmpty()) {
        List<PersonalizedUserDTO> randomUsers = recommendationMapper.findRandomUsers(5, pageCode);
        for (PersonalizedUserDTO user : randomUsers) {
          if (userIds.add(user.getUserSeq())) {
            recommendations.add(user);
          }
        }
        return recommendations;
      }

      int maxTotalScore = interests.stream()
          .mapToInt(InterestAccumulationDTO::getTotalScore)
          .max()
          .orElse(0);

      List<InterestAccumulationDTO> topDishInterests = interests.stream()
          .filter(interest -> interest.getTotalScore() == maxTotalScore)
          .collect(Collectors.toList());

      if (!topDishInterests.isEmpty()) {
        InterestAccumulationDTO topDishInterest = topDishInterests.get(
            new Random().nextInt(topDishInterests.size()));
        String topDish = topDishInterest.getDish();
        String topCategory = topDishInterest.getCategory();

        List<PersonalizedUserDTO> dishUsers = recommendationMapper.findByDish(topDish, pageCode);
        for (PersonalizedUserDTO user : dishUsers) {
          if (recommendations.size() < 3 && userIds.add(user.getUserSeq())) {
            recommendations.add(user);
          }
        }

        if (recommendations.size() < 5) {
          List<PersonalizedUserDTO> additionalUsers = recommendationMapper.findByCategoryExcludingDish(
                  topCategory, topDish, pageCode).stream()
              .filter(user -> userIds.add(user.getUserSeq()))
              .limit(2)
              .collect(Collectors.toList());
          recommendations.addAll(additionalUsers);
        }
      }

      if (recommendations.size() < 5) {
        List<PersonalizedUserDTO> randomUsers = recommendationMapper.findRandomUsers(
            5 - recommendations.size(), pageCode);
        for (PersonalizedUserDTO user : randomUsers) {
          if (recommendations.size() < 5 && userIds.add(user.getUserSeq())) {
            recommendations.add(user);
          }
        }
      }

      return recommendations.stream().limit(5).collect(Collectors.toList());
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException();
    }
  }

  @Override
  public List<TopPerformersDTO> getTopPerformers(String pageCode, int displayLimit) {
    return recommendationMapper.selectTopPerformers(pageCode, displayLimit);
  }
}
