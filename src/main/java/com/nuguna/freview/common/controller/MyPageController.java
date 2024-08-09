package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyPageController {

  @RequestMapping(value = "/my", method = RequestMethod.GET)
  public String moveToMyPage(@RequestParam Long userSeq) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    UserCode userCode = UserCode.from(loginUser.getCode());
    if (userCode.isAdmin()) {
      return "redirect:/admin";
    } else if (userCode.isCustomer()) {
      return "redirect:/my/brand-info";
    } else if (userCode.isStore()) {
      return "redirect:/store/my/brand?" + userSeq;
    } else {
      return "redirect:/main";
    }
  }
}
