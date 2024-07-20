package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.request.page.StoreActivityPageRequestDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreActivityPageResponseDTO;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
    return sendLike;
  }


  public StoreActivityPageResponseDTO storeActivityPage(@RequestBody StoreActivityPageRequestDTO reqDto) {
    Long userSeq = reqDto.getUserSeq();
    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
    return new StoreActivityPageResponseDTO(sendLike);
  }

//  @RequestMapping(value = "/send-like", method = RequestMethod.GET)
//  public List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(@RequestParam(value = "userSeq") Long userSeq) {
//    //TODO: 필요한 파라미터 - userSeq
//    //TODO: 보낼 데이터 - list
//    log.info("1 - 과연 " + userSeq);
////    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(
////        userSeq);
//    try {
//      List<StoreActivitySendLikeResponseDTO> sendLikelist = storeActivityPageService.storeActivityPageSendLike(
//          userSeq);
//      log.info("헤이" + sendLikelist.toString());
//      return sendLikelist;
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

}
