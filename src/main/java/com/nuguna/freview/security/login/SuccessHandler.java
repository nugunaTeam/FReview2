package com.nuguna.freview.security.login;

import com.nuguna.freview.security.JwtUtil;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessHandler implements AuthenticationSuccessHandler {

  JwtUtil jwtUtil;

  SuccessHandler(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Authentication authentication)
      throws IOException, ServletException {

    CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

    Long userSeq = customUserDetail.getUserVO().getSeq();
    String userEmail = customUserDetail.getUsername();
    Collection<GrantedAuthority> authorities = customUserDetail.getAuthorities();
    Iterator<GrantedAuthority> iterator = authorities.iterator();
    GrantedAuthority grantedAuthority = iterator.next();
    String role = grantedAuthority.getAuthority();

    String businessNumber = customUserDetail.getUserVO().getBusinessNumber();
    String code = customUserDetail.getUserVO().getCode();
    String nickname = customUserDetail.getUserVO().getNickname();
    String profilePhotoUrl = customUserDetail.getUserVO().getProfilePhotoUrl();
    String introduce = customUserDetail.getUserVO().getIntroduce();
    String subEmail = customUserDetail.getUserVO().getSubEmail();
    String loginType = customUserDetail.getUserVO().getLoginType();
    Boolean isWithDrawn = customUserDetail.getUserVO().getIsWithDrawn();
    String ageGroup = customUserDetail.getUserVO().getAgeGroup();
    String storeLocation = customUserDetail.getUserVO().getStoreLocation();

    //jwt 생성
    String accessToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 60, businessNumber, code, nickname, profilePhotoUrl, introduce, subEmail, loginType, isWithDrawn, ageGroup, storeLocation);
    String refreshToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 60, businessNumber, code, nickname, profilePhotoUrl, introduce, subEmail, loginType, isWithDrawn, ageGroup, storeLocation);

    Cookie accessCookie = new Cookie("access", accessToken);
    accessCookie.setPath("/");
    accessCookie.setMaxAge(10);
    accessCookie.setSecure(true);

    Cookie refreshCookie = new Cookie("refresh", refreshToken);
    refreshCookie.setPath("/");
    refreshCookie.setMaxAge(60*60);
    refreshCookie.setSecure(true);

    httpServletResponse.addCookie(accessCookie);
    httpServletResponse.addCookie(refreshCookie);
    httpServletResponse.sendRedirect("/main-page");
  }

}
