package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.InterestAccumulationDTO;
import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import com.nuguna.freview.common.mapper.InterestAccumulationMapper;
import com.nuguna.freview.common.mapper.RecommendationMapper;
import com.nuguna.freview.common.mapper.UserMapper;
import com.nuguna.freview.common.service.RecommendationService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecommendationServiceImpl implements RecommendationService {

  private final RecommendationMapper recommendationMapper;
  private final UserMapper userMapper;
  private final InterestAccumulationMapper interestAccumulationMapper;

  @Autowired
  public RecommendationServiceImpl(RecommendationMapper recommendationMapper, UserMapper userMapper,
      InterestAccumulationMapper interestAccumulationMapper) {
    this.recommendationMapper = recommendationMapper;
    this.userMapper = userMapper;
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
  public List<PersonalizedUserDTO> getPersonalizedRecommendationUsers(Long userSeq) {
    List<PersonalizedUserDTO> recommendations = new ArrayList<>();
    Set<Long> userIds = new HashSet<>();

    List<InterestAccumulationDTO> interests = interestAccumulationMapper.getByUserSeq(userSeq);

    Optional<InterestAccumulationDTO> topDishInterestOpt = interests.stream()
            .max(Comparator.comparing(InterestAccumulationDTO::getTotalScore));

    if (topDishInterestOpt.isPresent()) {
      InterestAccumulationDTO topDishInterest = topDishInterestOpt.get();
      String topDish = topDishInterest.getDish();
      String topCategory = topDishInterest.getCategory();

      List<PersonalizedUserDTO> dishUsers = userMapper.findByDish(topDish);
      for (PersonalizedUserDTO user : dishUsers) {
        if (recommendations.size() < 3 && userIds.add(user.getUserSeq())) {
          recommendations.add(user);
        }
      }

      if (recommendations.size() < 5) {
        List<PersonalizedUserDTO> additionalUsers = userMapper.findByCategoryExcludingDish(topCategory, topDish).stream()
            .filter(user -> userIds.add(user.getUserSeq()))
            .limit(2)
            .collect(Collectors.toList());
        recommendations.addAll(additionalUsers);
      }
    }

    if (recommendations.size() < 5) {
      List<PersonalizedUserDTO> randomUsers = userMapper.findRandomUsers(5 - recommendations.size());
      for (PersonalizedUserDTO user : randomUsers) {
        if (recommendations.size() < 5 && userIds.add(user.getUserSeq())) {
          recommendations.add(user);
        }
      }
    }

    return recommendations.stream().limit(5).collect(Collectors.toList());
  }
}
