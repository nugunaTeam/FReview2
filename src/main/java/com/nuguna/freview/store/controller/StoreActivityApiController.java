package com.nuguna.freview.store.controller;

import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;
import com.nuguna.freview.store.mapper.StoreActivityPageMapper;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/store/activity")
public class StoreActivityApiController {

  private final StoreActivityPageMapper storeActivityPageMapper;
  private final StoreActivityPageService storeActivityPageService;


  @Autowired
  public StoreActivityApiController(StoreActivityPageMapper storeActivityPageMapper,
      StoreActivityPageService storeActivityPageService) {
    this.storeActivityPageMapper = storeActivityPageMapper;
    this.storeActivityPageService = storeActivityPageService;
  }

  // 보낸 좋아요
  @RequestMapping(value = "/send-like", method = RequestMethod.GET)
  public List<StoreActivitySendLikeResponseDTO> storeActivitySendLike(
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer targetPage) {
    StoreListPaginationResponseDTO paginationInfo = new StoreListPaginationResponseDTO(targetPage);
    return storeActivityPageService.storeActivityPageSendLike(userSeq, paginationInfo);
  }

  // 보낸 찜 ( 체험단 )
  @RequestMapping(value = "/send-zzim-to-customer", method = RequestMethod.GET)
  public StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimToCustomer(
      @RequestParam("userSeq") Long userSeq,
      @RequestParam Integer targetPage) throws IllegalPageAccessException {
    return storeActivityPageService.storeActivitySendZzimCustomer(userSeq, targetPage);
  }

  // 작성한 글
  @RequestMapping(value = "/written-post", method = RequestMethod.GET)
  public List<StoreActivityWrittenPostResponseDTO> storeActivityWrittenPost(@RequestParam("userSeq") Long userSeq,
      @RequestParam Integer targetPage) {
    StoreListPaginationResponseDTO paginationInfo = new StoreListPaginationResponseDTO(targetPage);
    return storeActivityPageService.storeActivityPageWrittenPost(userSeq, paginationInfo);
  }


}