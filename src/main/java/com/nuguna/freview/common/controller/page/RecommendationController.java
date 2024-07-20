package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/recommendation")
public class RecommendationController {

  private final UserService userService;

  @Autowired
  public RecommendationController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/customer", method = RequestMethod.GET)
  public String customerRecommendationPage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-customer-recommendation";
  }

  @RequestMapping(value = "/store", method = RequestMethod.GET)
  public String storeRecommendationPage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-store-recommendation";
  }
}
