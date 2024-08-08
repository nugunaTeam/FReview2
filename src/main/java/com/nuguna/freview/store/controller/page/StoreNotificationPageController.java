package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.service.StoreNotificationPageService;
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
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);
    return "store-notification-page";
  }
}
