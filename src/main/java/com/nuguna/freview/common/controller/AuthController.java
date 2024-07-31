package com.nuguna.freview.common.controller;

import com.nuguna.freview.OAuth.dto.response.GoogleUserInfoDTO;
import com.nuguna.freview.OAuth.service.OAuthService;
import com.nuguna.freview.OAuth.service.impl.OAuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class AuthController {

  final OAuthService oauthService;

  @Autowired
  public AuthController(OAuthService oauthService) {
    this.oauthService = oauthService;
  }

  @RequestMapping(value = "/login-page", method = RequestMethod.GET)
  public String goToLogin(Model model) {
    log.info("로그인 페이지로 이동");
    String googleLoginUrl = oauthService.getLoginFormUrl();
    model.addAttribute("googleLoginUrl", googleLoginUrl);
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
