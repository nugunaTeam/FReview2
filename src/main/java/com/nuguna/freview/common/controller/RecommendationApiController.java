package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.RecommendationListRequestDTO;
import com.nuguna.freview.common.dto.request.RecommendationFilteringRequestDTO;
import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import com.nuguna.freview.common.dto.response.page.RecommendationListResponseDTO;
import com.nuguna.freview.common.service.RecommendationService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/recommendation")
public class RecommendationApiController {

  private final RecommendationService recommendationService;
  private final int PAGE_SIZE = 20;

  @Autowired
  public RecommendationApiController(RecommendationService customerService) {
    this.recommendationService = customerService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public RecommendationListResponseDTO getRecommendation(
      @RequestBody RecommendationListRequestDTO requestDTO) {
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    String userCode = requestDTO.getUserCode();

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }

    RecommendationListResponseDTO responseDTO = new RecommendationListResponseDTO();
    try {
      List<RecommendationResponseDTO> userList = recommendationService.getRecommendationUserList(
          previousUserSeq, PAGE_SIZE, userCode);
      boolean hasMore = userList.size() == PAGE_SIZE;
      responseDTO.setUserList(userList);
      responseDTO.setHasMore(hasMore);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseDTO;
  }

  @RequestMapping(value = "/filter", method = RequestMethod.POST)
  public RecommendationListResponseDTO filterRecommendation(
      @RequestBody RecommendationFilteringRequestDTO requestDTO) {
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    List<String> foodTypes = requestDTO.getFoodTypes();
    List<String> tags = requestDTO.getTags();
    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    String userCode = requestDTO.getUserCode();

    RecommendationListResponseDTO responseDTO = new RecommendationListResponseDTO();
    try {
      List<RecommendationResponseDTO> customerList = recommendationService.getFilteredRecommendationUserList(
          previousUserSeq, PAGE_SIZE, foodTypes, tags, userCode);
      boolean hasMore = customerList.size() == PAGE_SIZE;
      responseDTO.setUserList(customerList);
      responseDTO.setHasMore(hasMore);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseDTO;
  }
}

