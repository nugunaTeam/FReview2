package com.nuguna.freview.OAuth.controller;

import com.nuguna.freview.OAuth.dto.response.GoogleUserInfoDTO;
import com.nuguna.freview.OAuth.service.OAuthService;
import com.nuguna.freview.OAuth.service.OAuthUserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class OAuthController {

  private final OAuthService oauthService;
  private final OAuthUserService oauthUserService;

  @Autowired
  public OAuthController(OAuthService oauthService, OAuthUserService oauthUserService) {
    this.oauthService = oauthService;
    this.oauthUserService = oauthUserService;
  }

  @RequestMapping(value="/oauth2callback", method = RequestMethod.GET)
  public String ctlCallback(Model model, RedirectAttributes redirectAttributes,
      @RequestParam("code") String code, HttpServletRequest request) {

    String accessToken = oauthService.getRequestAccessToken(code);
    GoogleUserInfoDTO userInfo = oauthService.getRequestUserInfo(accessToken);
    boolean userCheck = oauthUserService.checkUser(userInfo.getEmail());
    if(!userCheck){
      request.getSession().setAttribute("OAuthUser", userInfo);
      return "redirect: /oauth-register-page";
    }else{
    return "/login-page";}
  }

  @RequestMapping(value="/oauth-register-page", method = RequestMethod.GET)
  public String goToRegisterPage(Model model, HttpServletRequest httpRequest) {

    GoogleUserInfoDTO userInfo = (GoogleUserInfoDTO)httpRequest.getSession().getAttribute("OAuthUser");
    System.out.println(userInfo);
    model.addAttribute("userInfo", userInfo);
    return "/common-oauth-register";
  }

}
