package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.CustomerRecommendationResponseDTO;
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
  public List<CustomerRecommendationResponseDTO> getRecommendationCustomerList(Long previousSeq,
      int limit) {
    return recommendationMapper.selectCustomer(previousSeq, limit);
  }

  @Override
  public List<CustomerRecommendationResponseDTO> getFilteredRecommendationCustomerList(
      Long previousSeq, int limit, List<String> foodTypes, List<String> tags, String code) {
    return recommendationMapper.filterUsers(previousSeq, limit, foodTypes, tags, code);
  }
}
