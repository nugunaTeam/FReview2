package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.CustomerRecommendationResponseDTO;
import java.util.List;

public interface RecommendationService {

  List<CustomerRecommendationResponseDTO> getRecommendationCustomerList(Long previousSeq, int limit);
  List<CustomerRecommendationResponseDTO> getFilteredRecommendationCustomerList(Long previousSeq, int limit, List<String> foodTypes, List<String> tags, String code);
}
