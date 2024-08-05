package com.nuguna.freview.store.controller;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.login.CustomUserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class StoreMainPageController {

  @RequestMapping("/store/main-page")
  public String customerMyBrandPage(Model model) {

    return "store_main";
  }

}
