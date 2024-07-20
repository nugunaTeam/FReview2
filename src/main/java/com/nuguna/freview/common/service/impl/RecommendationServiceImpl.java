package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import com.nuguna.freview.common.mapper.RecommendationMapper;
import com.nuguna.freview.common.service.RecommendationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

  private final RecommendationMapper recommendationMapper;

  @Autowired
  public RecommendationServiceImpl(RecommendationMapper recommendationMapper) {
    this.recommendationMapper = recommendationMapper;
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
}
