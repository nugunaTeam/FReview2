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

}
