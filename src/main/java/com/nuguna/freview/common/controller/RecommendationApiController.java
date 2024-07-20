package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.CustomerRecommendationListRequestDTO;
import com.nuguna.freview.common.dto.request.RecommendationFilteringRequestDTO;
import com.nuguna.freview.common.dto.response.CustomerRecommendationResponseDTO;
import com.nuguna.freview.common.dto.response.page.CustomerRecommendationListResponseDTO;
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
@RequestMapping("/api/common/recommendation/customer")
public class RecommendationApiController {

  private final RecommendationService customerService;
  private final int PAGE_SIZE = 20;

  @Autowired
  public RecommendationApiController(RecommendationService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public CustomerRecommendationListResponseDTO getRecommendation(
      @RequestBody CustomerRecommendationListRequestDTO requestDTO) {
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    String searchWord = requestDTO.getSearchWord();

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }

    CustomerRecommendationListResponseDTO responseDTO = new CustomerRecommendationListResponseDTO();
    try {
      List<CustomerRecommendationResponseDTO> customerList = customerService.getRecommendationCustomerList(
          previousUserSeq, PAGE_SIZE);
      boolean hasMore = customerList.size() == PAGE_SIZE;
      responseDTO.setCustomerList(customerList);
      responseDTO.setHasMore(hasMore);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseDTO;
  }

  @RequestMapping(value = "/filter", method = RequestMethod.POST)
  public CustomerRecommendationListResponseDTO filterRecommendation(
      @RequestBody RecommendationFilteringRequestDTO requestDTO) {
    log.info("Received filter request with foodTypes {} and tags {}", requestDTO.getFoodTypes(), requestDTO.getTags());
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    List<String> foodTypes = requestDTO.getFoodTypes();
    List<String> tags = requestDTO.getTags();
    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    String code = "CUSTOMER";

    CustomerRecommendationListResponseDTO responseDTO = new CustomerRecommendationListResponseDTO();
    try {
      List<CustomerRecommendationResponseDTO> customerList = customerService.getFilteredRecommendationCustomerList(
          previousUserSeq, PAGE_SIZE, foodTypes, tags, code);
      boolean hasMore = customerList.size() == PAGE_SIZE;
      responseDTO.setCustomerList(customerList);
      responseDTO.setHasMore(hasMore);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseDTO;
  }
}

