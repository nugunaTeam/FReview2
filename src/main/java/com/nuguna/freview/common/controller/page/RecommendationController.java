package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/recommendation")
public class RecommendationController {

  @RequestMapping(value = "/customer", method = RequestMethod.GET)
  public String customerRecommendationPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "common-customer-recommendation";
  }

  @RequestMapping(value = "/store", method = RequestMethod.GET)
  public String storeRecommendationPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "common-store-recommendation";
  }
}
