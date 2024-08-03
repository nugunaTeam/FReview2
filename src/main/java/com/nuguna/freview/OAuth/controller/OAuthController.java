package com.nuguna.freview.OAuth.controller;

import com.nuguna.freview.OAuth.OAuthUserVO;
import com.nuguna.freview.OAuth.dto.response.GoogleUserInfoDTO;
import com.nuguna.freview.OAuth.service.OAuthService;
import com.nuguna.freview.OAuth.service.OAuthUserService;
import com.nuguna.freview.security.JwtUtil;
import com.nuguna.freview.security.login.CustomUserDetail;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
  final JwtUtil jwtUtil;

  @Autowired
  public OAuthController(OAuthService oauthService, OAuthUserService oauthUserService, JwtUtil jwtUtil) {
    this.oauthService = oauthService;
    this.oauthUserService = oauthUserService;
    this.jwtUtil = jwtUtil;
  }

  @RequestMapping(value="/oauth2callback", method = RequestMethod.GET)
  public String ctlCallback(Model model, RedirectAttributes redirectAttributes,
      @RequestParam("code") String code, HttpServletRequest request) {

    String accessToken = oauthService.getRequestAccessToken(code);
    GoogleUserInfoDTO userInfo = oauthService.getRequestUserInfo(accessToken);
    boolean userCheck = oauthUserService.checkUser(userInfo.getEmail());
    request.getSession().setAttribute("OAuthUser", userInfo);
    if(!userCheck){
      return "redirect: /google-register-page";
    }else{
    return "redirect: /google-login";}
  }

  @RequestMapping(value="/google-register-page", method = RequestMethod.GET)
  public String goToRegisterPage(Model model, HttpServletRequest httpRequest) {

    GoogleUserInfoDTO userInfo = (GoogleUserInfoDTO)httpRequest.getSession().getAttribute("OAuthUser");
    System.out.println(userInfo);
    model.addAttribute("userInfo", userInfo);
    return "/common-google-register";
  }

  @RequestMapping(value="/google-login", method = RequestMethod.GET)
  public String googleLogin(Model model, HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
    GoogleUserInfoDTO userInfo = (GoogleUserInfoDTO) httpRequest.getSession().getAttribute("OAuthUser");
    String username = userInfo.getEmail();
    OAuthUserVO oauthUser = oauthUserService.loadUserByUsername(username);
    Long userSeq = oauthUser.getUservo().getSeq();
    String userEmail = oauthUser.getUservo().getEmail();
    String role = oauthUser.getRole();

    //jwt 생성
    String accessToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 60);
    String refreshToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 180);

    // 리프레시 토큰 쿠키에 저장
    Cookie refreshCookie = new Cookie("refresh", refreshToken);
    refreshCookie.setPath("/");
    refreshCookie.setMaxAge(60*180);
    refreshCookie.setSecure(true);

    //액세스 토큰 쿠키에 저장
    Cookie accessCookie = new Cookie("access", accessToken);
    refreshCookie.setPath("/");
    refreshCookie.setMaxAge(60*180);
    refreshCookie.setSecure(true);

    httpServletResponse.addCookie(accessCookie);
    httpServletResponse.addCookie(refreshCookie);
    if(role.equals("ROLE_ADMIN")) {
      return "redirect: /admin/manage/store";
    }else if(role.equals("ROLE_CUSTOMER")) {
      return "redirect: /customer/main-page";
    } else{
      return "redirect: /user/main-page";
    }
  }

}
