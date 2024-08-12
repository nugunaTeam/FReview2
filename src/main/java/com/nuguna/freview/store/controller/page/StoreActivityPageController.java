package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.service.StoreActivityPageService;
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
  private final UserService userService;

  @Autowired
  public StoreActivityPageController(StoreActivityPageService storeActivityPageService,
      UserService userService) {
    this.storeActivityPageService = storeActivityPageService;
    this.userService = userService;
  }

  @RequestMapping("/store/activity")
  public String storeActivityPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);
    return "store-activity-page";
  }
}
