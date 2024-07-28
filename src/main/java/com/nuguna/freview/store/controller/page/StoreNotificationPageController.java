package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
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
  private final UserService userService;

  @Autowired
  public StoreNotificationPageController(StoreNotificationPageService storeNotificationPageService,
      UserService userService) {
    this.storeNotificationPageService = storeNotificationPageService;
    this.userService = userService;
  }

  @RequestMapping("/store/notification")
  public String storeNotificationPage(@RequestParam Long userSeq, Model model) {
    //userSeq = 41L;
    UserVO loginUser = userService.getUserInfo(userSeq);
    List<StoreNotificationReceivedLikeResponseDTO> receivedLike = storeNotificationPageService.storeNotificationReceivedLike(userSeq);
    List<StoreNotificationReceivedZzimCustomerResponseDTO> receivedZzimCustomer = storeNotificationPageService.storeNotificationReceivedZzimCustomer(userSeq);
    List<StoreNotificationReceivedZzimStoreResponseDTO> receivedZzimStore = storeNotificationPageService.storeNotificationReceivedZzimStore(userSeq);
    List<StoreNotificationExperienceApplyResponseDTO> experienceApply = storeNotificationPageService.storeNotificationExperienceApply(userSeq);
    List<StoreNotificationExperienceProposeResponseDTO> experiencePropose = storeNotificationPageService.storeNotificationExperiencePropose(userSeq);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("receivedLike", receivedLike);
    model.addAttribute("receivedZzimCustomer", receivedZzimCustomer);
    model.addAttribute("receivedZzimStore", receivedZzimStore);
    model.addAttribute("experienceApply", experienceApply);
    model.addAttribute("experiencePropose", experiencePropose);
    return "store-notification-page";
  }
}
