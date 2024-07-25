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

    //jwt 생성
    String accessToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 60);
    String refreshToken = jwtUtil.createToken(userSeq, userEmail, role,1000L * 60 * 180);

    // 리프레시 토큰 쿠키에 저장
    Cookie refreshCookie = new Cookie("refresh", refreshToken);
    refreshCookie.setPath("/");
    refreshCookie.setMaxAge(60*180);
    refreshCookie.setSecure(true);

    httpServletResponse.setHeader("Authorization", "Bearer " + accessToken);
    httpServletResponse.addCookie(refreshCookie);
    String targetUrl = determinTargetUrl(role);
    httpServletResponse.sendRedirect(targetUrl);
  }

  private String determinTargetUrl(String role) {
    if(role.equals("ROLE_ADMIN")) {
      return "/admin/manage/store";
    }else if(role.equals("ROLE_CUSTOMER")) {
      return "/customer/main-page";
    } else if(role.equals("ROLE_STORE")) {
      return "/store/main-page";
    }
    return "/error";
  }


}
