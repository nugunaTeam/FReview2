package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.service.StoreExperiencePageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class StoreExperiencePageController {

  private final StoreExperiencePageService storeExperiencePageService;
  private final UserService userService;

  @Autowired
  public StoreExperiencePageController(StoreExperiencePageService storeExperiencePageService,
      UserService userService) {
    this.storeExperiencePageService = storeExperiencePageService;
    this.userService = userService;
  }

  @RequestMapping("/store/experience")
  public String storeActivityPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);
    return "store-experience-page";
  }
}
