package com.nuguna.freview.security.login;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.login.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  LoginService loginService;

  @Autowired
  public CustomUserDetailsService(LoginService loginService) {
    this.loginService = loginService;
  }

  @Override
  public CustomUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {

    UserVO userVO = loginService.searchUserByID(email);
    if(userVO == null) {
      throw new UsernameNotFoundException("이메일을 찾을 수 없습니다");
    }
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    if(userVO.getCode().equals("ADMIN")){
      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }else if(userVO.getCode().equals("CUSTOMER")){
      authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
    }else if(userVO.getCode().equals("STORE")){
      authorities.add(new SimpleGrantedAuthority("ROLE_STORE"));
    }
    return new CustomUserDetail(email, userVO.getPassword(), authorities,userVO);
  }
}
