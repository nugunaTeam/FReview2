package com.nuguna.freview.store.controller;

import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_SIZE;

import com.nuguna.freview.store.dto.response.page.StoreApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreReviewListResponseDTO;
import com.nuguna.freview.store.service.StoreExperiencePageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/store/experience")
public class StoreExperienceApiController {

  private final StoreExperiencePageService storeExperiencePageService;

  @Autowired
  public StoreExperienceApiController(StoreExperiencePageService storeExperiencePageService) {
      this.storeExperiencePageService = storeExperiencePageService;
  }

  // ------------------ 지원자 리스트
  @RequestMapping(value="/apply-list", method = RequestMethod.GET)
  public StoreApplyListResponseDTO applyList(@RequestParam Long userSeq, @RequestParam Integer currentPage){
      return storeExperiencePageService.applyList(userSeq, currentPage, STORE_LIST_PAGE_SIZE);
  }

  // 지원자 상태 변경 = 지원 수락
  @RequestMapping(value = "/apply-confirm", method = RequestMethod.POST)
  public ResponseEntity<?> applyConfirm(@RequestParam Long experienceSeq) {
    try {
      storeExperiencePageService.applyConfirm(experienceSeq);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  // ------------------  제안자 리스트
  @RequestMapping(value = "/proposal-list", method = RequestMethod.GET)
  public StoreProposalListResponseDTO proposalList(@RequestParam Long userSeq, @RequestParam Integer currentPage) {
    return  storeExperiencePageService.proposalList(userSeq, currentPage, STORE_LIST_PAGE_SIZE);
  }


  // ------------------  확정 리스트
  // 지원
  @RequestMapping(value = "/final-apply-list", method = RequestMethod.GET)
  public StoreFinalApplyListResponseDTO finalApplyList(@RequestParam Long userSeq, @RequestParam Integer currentPage){
    return storeExperiencePageService.finalApplyList(userSeq, currentPage, STORE_LIST_PAGE_SIZE);
  }

  // 제안
  @RequestMapping(value = "/final-proposal-list", method = RequestMethod.GET)
  public StoreFinalProposalListResponseDTO finalProposalList(@RequestParam Long userSeq, @RequestParam Integer currentPage){
    return storeExperiencePageService.finalProposalList(userSeq, currentPage, STORE_LIST_PAGE_SIZE);
  }


  // 체험일자 확정
  // 체험일자는 DATE 타입으로 들어온다.
  @RequestMapping(value = "/experience-date-update", method = RequestMethod.POST)
  public ResponseEntity<?> updateExperienceDate(@RequestParam Long experienceSeq){
    try{
      storeExperiencePageService.updateExperienceDate(experienceSeq);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  // 체험 여부 확인 (방문 했냐? 노쇼냐?) jsp에서 들어올 값은 status도 있다~!
  // 컨트롤러 하나 ajax도 하나 버튼은 두개, 확정버튼status = ACCEPTED / 노쇼버튼status = NOSHOW
  @RequestMapping(value = "/experiece-update-status", method = RequestMethod.POST)
  public ResponseEntity<?> updateExperienceStatus(@RequestParam Long experienceSeq, @RequestParam String status){
    try{
      storeExperiencePageService.updateExperienceStatus(experienceSeq, status);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }




  // ------------------  리뷰 리스트
  @RequestMapping(value = "/review-list", method = RequestMethod.GET)
  public StoreReviewListResponseDTO storeReviewList(@RequestParam Long userSeq, @RequestParam Integer currentPage) {
    return storeExperiencePageService.storeReviewList(userSeq, currentPage, STORE_LIST_PAGE_SIZE);
  }


  // 리뷰 숨김 버튼
  @RequestMapping(value = "/review-hidden", method = RequestMethod.POST)
  public ResponseEntity<?> updateReviewStatus(@RequestParam Long customerSeq, @RequestParam String status) {
    log.info("여기진입");
    try{
      storeExperiencePageService.updateReviewStatus(customerSeq, status);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
