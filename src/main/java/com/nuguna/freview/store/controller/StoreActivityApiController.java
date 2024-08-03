package com.nuguna.freview.store.controller;

import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.mapper.StoreActivityPageMapper;
import com.nuguna.freview.store.service.StoreActivityPageService;
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
  public StoreActivitySendLikeResponseDTO storeActivitySendLike(
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer targetPage) throws IllegalPageAccessException {
      return storeActivityPageService.storeActivityPageSendLike(userSeq, targetPage);
  }

  // 보낸 찜 ( 체험단 )
  @RequestMapping(value = "/send-zzim-to-customer", method = RequestMethod.GET)
  public StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimToCustomer(
      @RequestParam("userSeq") Long userSeq,
      @RequestParam Integer targetPage) throws IllegalPageAccessException {
    return storeActivityPageService.storeActivitySendZzimCustomer(userSeq, targetPage);
  }

  // 보낸 찜 ( 스토어 )
  @RequestMapping(value = "/send-zzim-to-store", method = RequestMethod.GET)
  public StoreActivitySendZzimStoreResponseDTO storeActivitySendZzimStore(
      @RequestParam("userSeq") Long userSeq,
      @RequestParam Integer targetPage) throws IllegalPageAccessException {
    return storeActivityPageService.storeActivitySendZzimStore(userSeq, targetPage);
  }

  // 작성한 글
  @RequestMapping(value = "/written-post", method = RequestMethod.GET)
  public StoreActivityWrittenPostResponseDTO storeActivityWrittenPost(@RequestParam("userSeq") Long userSeq,
      @RequestParam Integer targetPage) throws IllegalPageAccessException {
    return storeActivityPageService.storeActivityPageWrittenPost(userSeq, targetPage);
  }


}
