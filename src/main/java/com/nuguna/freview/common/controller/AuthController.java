package com.nuguna.freview.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class AuthController {

  @RequestMapping(value = "/login-page", method = RequestMethod.GET)
  public String goToLogin() {
    log.info("로그인 페이지로 이동");
    return "common-login";
  }

  @RequestMapping(value = "/register-page", method = RequestMethod.GET)
  public String goToRegister() {
    log.info("회원가입 페이지로 이동");
    return "common-register";
  }

  @RequestMapping(value = "/login-fail-page", method = RequestMethod.GET)
  public String goToLoginFail() {
    log.info("로그인 에러 페이지로 이동");
    return "common-login-fail";
  }

}
