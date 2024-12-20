package com.nuguna.freview.security.jwtfilter;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.JwtUtil;
import com.nuguna.freview.security.jwtfilter.service.JwtUserService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class JWTfilter extends OncePerRequestFilter {

  final JwtUtil jwtutl;

  public JWTfilter(JwtUtil jwtutl) {
    this.jwtutl = jwtutl;
  }


  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    Cookie[] cookies = httpServletRequest.getCookies();
    String accessToken = null;
    String refreshToken = null;

    for(Cookie c : cookies) {
      if(c.getName().equals("access")) {
        accessToken = c.getValue();
      }
      if(c.getName().equals("refresh")) {
        refreshToken = c.getValue();
      }
    }

    // accessToken만 없으면 토큰 재생성, refreshToken까지 없으면 로그아웃
    if(refreshToken != null) {

      if(accessToken == null) {

        Cookie[] cookiess = httpServletRequest.getCookies();
        for(Cookie c : cookiess) {
          if(c.getName().equals("refresh")) {
            c.setValue("");
            c.setPath("/");
            c.setMaxAge(0); // 쿠키 만료 설정
            httpServletResponse.addCookie(c);
          }
        }

        Cookie accessCookie = new Cookie("access", refreshToken);
        accessCookie.setPath("/");
        accessCookie.setMaxAge(10);
        accessCookie.setSecure(true);
        httpServletResponse.addCookie(accessCookie);

        Cookie refreshCookie = new Cookie("refresh", refreshToken);
        refreshCookie.setPath("/");
        refreshCookie.setMaxAge(60*60);
        refreshCookie.setSecure(true);
        httpServletResponse.addCookie(refreshCookie);

        accessToken = refreshToken;
      }

      String role = jwtutl.getRole(accessToken);
      String email = jwtutl.getUserEmail(accessToken);
      Long seq = jwtutl.getUserSeq(accessToken);
      String businessNumber = jwtutl.getBusinessNumber(accessToken);
      String code = jwtutl.getCode(accessToken);
      String nickname = jwtutl.getNickname(accessToken);
      String profile = jwtutl.getProfilePhotoUrl(accessToken);
      String introduce = jwtutl.getIntroduce(accessToken);
      String subEmail = jwtutl.getSubEmail(accessToken);
      String loginType = jwtutl.getLoginType(accessToken);
      boolean isWithDrawn = jwtutl.getIsWithDrawn(accessToken);
      String ageGroup = jwtutl.getAgeGroup(accessToken);
      String storeLocation = jwtutl.getStoreLocation(accessToken);

      UserVO uvo = new UserVO(seq, businessNumber, code, email, null, nickname, profile, introduce,
          subEmail, loginType, isWithDrawn, ageGroup, storeLocation, null, null);

      JwtContextHolder.setUserVO(uvo);


    }else{
      String requestURI = httpServletRequest.getRequestURI();
      if(requestURI.equals("/main")) {
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/main");
        dispatcher.forward(httpServletRequest, httpServletResponse);
        return;
      }
      httpServletResponse.sendRedirect("/expired-token");
      return;
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
