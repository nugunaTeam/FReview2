package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
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
@RequestMapping("/api/store/activity")
public class StoreActivityApiController {

  private final StoreActivityPageService storeActivityPageService;

  @Autowired
  public StoreActivityApiController(StoreActivityPageService storeActivityPageService) {
    this.storeActivityPageService = storeActivityPageService;
  }

  @RequestMapping(value = "/send-like", method = RequestMethod.GET)
  public List<StoreActivitySendLikeResponseDTO> storeActivitySendLike(@RequestParam("userSeq") Long userSeq) {
//    throw new RuntimeException();
    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
    log.info("Send like: {}", sendLike);
    return sendLike;
  }

  @RequestMapping(value = "/send-zzim", method = RequestMethod.GET)
  public ResponseEntity<?> storeActivitySendZzim(@RequestParam("userSeq") Long userSeq, @RequestParam("code") String code) {
    if("CUSTOMER".equals(code)) {
      List<StoreActivitySendZzimCustomerResponseDTO> sendZzimCustomer = storeActivityPageService.storeActivitySendZzimCustomer(userSeq);
      return new ResponseEntity<>(sendZzimCustomer, HttpStatus.OK);
    } else {
      List<StoreActivitySendZzimStoreResponseDTO> sendZzimStore = storeActivityPageService.storeActivitySendZzimStore(userSeq);
      return new ResponseEntity<>(sendZzimStore, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/written-post", method = RequestMethod.GET)
  public List<StoreActivityWrittenPostResponseDTO> storeActivityWrittenPost(@RequestParam("userSeq") Long userSeq) {
//    throw new RuntimeException();
    List<StoreActivityWrittenPostResponseDTO> writtenPost = storeActivityPageService.storeActivityPageWrittenPost(userSeq);
    return writtenPost;
  }

}
