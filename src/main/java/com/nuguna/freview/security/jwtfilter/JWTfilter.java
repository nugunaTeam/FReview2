package com.nuguna.freview.security.jwtfilter;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.JwtUtil;
import com.nuguna.freview.security.jwtfilter.service.JwtUserService;
import com.nuguna.freview.security.login.CustomUserDetail;
import com.nuguna.freview.security.login.service.LoginService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class JWTfilter extends OncePerRequestFilter {

  final JwtUtil jwtutl;
  private final JwtUserService jwtUserService;

  public JWTfilter(JwtUtil jwtutl, JwtUserService jwtUserService) {
    this.jwtutl = jwtutl;
    this.jwtUserService = jwtUserService;
  }


  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    log.info("JWTfilter doFilterInternal");
    Cookie[] cookies = httpServletRequest.getCookies();
    String accessToken = null;
    String refreshToken = null;
    for(Cookie c : cookies) {
      if(c.getName().equals("refresh")) {
        refreshToken = c.getValue();
      }
      if(c.getName().equals("access")) {
        accessToken = c.getValue();
      }
    }

    String role = jwtutl.getRole(accessToken);
    String email = jwtutl.getUserEmail(accessToken);

    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(grantedAuthority);

    UserVO uvo = jwtUserService.searchUserByID(email);
    CustomUserDetail customUserDetail = new CustomUserDetail(email,"password",grantedAuthorities,uvo);
    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(customUserDetail,null,grantedAuthorities));
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
