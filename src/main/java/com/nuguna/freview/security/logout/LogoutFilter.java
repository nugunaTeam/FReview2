package com.nuguna.freview.security.logout;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class LogoutFilter extends OncePerRequestFilter {


  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws IOException {

    Cookie[] cookies = httpServletRequest.getCookies();

    for(Cookie c : cookies) {
      if(c.getName().equals("access")) {
        c.setValue("");
        c.setPath("/");
        c.setMaxAge(0); // 쿠키 만료 설정
        httpServletResponse.addCookie(c);
      }

      if(c.getName().equals("refresh")){
        c.setValue("");
        c.setPath("/");
        c.setMaxAge(0); // 쿠키 만료 설정
        httpServletResponse.addCookie(c);
      }

    }

    httpServletResponse.sendRedirect("/login-page");
  }
}
