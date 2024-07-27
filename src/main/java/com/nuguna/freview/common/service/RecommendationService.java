package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import java.util.List;

public interface RecommendationService {

  List<RecommendationResponseDTO> getRecommendationUserList(Long previousSeq, int limit, String userCode);
  List<RecommendationResponseDTO> getFilteredRecommendationUserList(Long previousSeq, int limit, List<String> foodTypes, List<String> tags, String UserCode);
  List<PersonalizedUserDTO> getPersonalizedRecommendationUsers(Long userSeq);
}
