package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class StoreNotificationPageController {
  private final StoreNotificationPageService storeNotificationPageService;

  @Autowired
  public StoreNotificationPageController(StoreNotificationPageService storeNotificationPageService) {
    this.storeNotificationPageService = storeNotificationPageService;
  }

  @RequestMapping("/store/notification")
  public String storeNotificationPage(@RequestParam Long userSeq, Model model) {
    List<StoreNotificationReceivedLikeResponseDTO> receivedLike = storeNotificationPageService.storeNotificationReceivedLike(userSeq);
    List<StoreNotificationReceivedZzimResponseDTO> receivedZzim = storeNotificationPageService.storeNotificationReceivedZzim(userSeq);
    List<StoreNotificationExperienceResponseDTO> experience = storeNotificationPageService.storeNotificationExperience(userSeq);
    model.addAttribute("receivedLike", receivedLike);
    model.addAttribute("receivedZzim", receivedZzim);
    model.addAttribute("experience", experience);
    return "store-notification-page";
  }
}
