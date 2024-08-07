package com.nuguna.freview.security.login;

import com.nuguna.freview.global.util.ShaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private final CustomUserDetailsService userDetailsService;
  final ShaUtil shautil;

  @Autowired
  CustomAuthenticationProvider(CustomUserDetailsService userDetailsService, ShaUtil shautil) {
    this.userDetailsService = userDetailsService;
    this.shautil = shautil;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    String shaPassword = ShaUtil.sha256Encoding(password);

    userDetailsService.checkPassword(shaPassword);
    CustomUserDetail customUserDetails = userDetailsService.loadUserByUsername(username);

    return new UsernamePasswordAuthenticationToken(customUserDetails, shaPassword, customUserDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
