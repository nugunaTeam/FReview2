package com.nuguna.freview.store.controller.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller

public class StoreActivityPageController {

  private final StoreActivityPageService storeActivityPageService;

  @Autowired
  public StoreActivityPageController(StoreActivityPageService storeActivityPageService) {
    this.storeActivityPageService = storeActivityPageService;
  }

  @RequestMapping("/store/activity")
  public String storeActivityPage(@RequestParam Long userSeq, Model model) throws JsonProcessingException {
    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
    model.addAttribute("sendLike", sendLike);
    return "store-activity-page";
  }
}
