package com.nuguna.freview.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class AuthController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String goToLogin() {
    log.info("로그인 페이지로 이동");
    return "common-login";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String goToRegister() {
    log.info("회원가입 페이지로 이동");
    return "common-register";
  }

}
