package com.nuguna.freview.common.controller;

import static com.nuguna.freview.common.constant.BoardPageConstant.RECOMMENDATION_BOARD_PAGE_SIZE;

import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import com.nuguna.freview.common.dto.request.PersonalizedUserRequestDTO;
import com.nuguna.freview.common.dto.request.RecommendationFilteringRequestDTO;
import com.nuguna.freview.common.dto.request.RecommendationListRequestDTO;
import com.nuguna.freview.common.dto.request.TopPerformersRequestDTO;
import com.nuguna.freview.common.dto.response.PersonalizedUsersResponseDTO;
import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import com.nuguna.freview.common.dto.TopPerformersDTO;
import com.nuguna.freview.common.dto.response.TopPerformersResponseDTO;
import com.nuguna.freview.common.dto.response.page.RecommendationListResponseDTO;
import com.nuguna.freview.common.service.RecommendationService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/recommendation")
public class RecommendationApiController {

  private final RecommendationService recommendationService;

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
          previousUserSeq, RECOMMENDATION_BOARD_PAGE_SIZE, userCode);
      boolean hasMore = userList.size() == RECOMMENDATION_BOARD_PAGE_SIZE;
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
      List<RecommendationResponseDTO> userList = recommendationService.getFilteredRecommendationUserList(
          previousUserSeq, RECOMMENDATION_BOARD_PAGE_SIZE, foodTypes, tags, userCode);
      boolean hasMore = userList.size() == RECOMMENDATION_BOARD_PAGE_SIZE;
      responseDTO.setUserList(userList);
      responseDTO.setHasMore(hasMore);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseDTO;
  }

  @RequestMapping(value = "/personalization", method = RequestMethod.POST)
  public ResponseEntity<PersonalizedUsersResponseDTO> customizeRecommendation(
      @RequestBody PersonalizedUserRequestDTO requestDTO) {
    Long userSeq = requestDTO.getRequesterSeq();
    String pageCode = requestDTO.getPageCode();

    List<PersonalizedUserDTO> recommendedUsers = recommendationService.getPersonalizedRecommendationUsers(
        userSeq, pageCode);

    PersonalizedUsersResponseDTO responseDTO = new PersonalizedUsersResponseDTO(recommendedUsers);

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }


  @RequestMapping(value = "/top-performers", method = RequestMethod.POST)
  public ResponseEntity<TopPerformersResponseDTO> topPerformersRecommendation(@RequestBody TopPerformersRequestDTO requestDTO) {
    String pageCode = requestDTO.getPageCode();
    int displayLimit = 10;

    List<TopPerformersDTO> topPerformers = recommendationService.getTopPerformers(pageCode, displayLimit);

    TopPerformersResponseDTO responseDTO = new TopPerformersResponseDTO(topPerformers);

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }
}
