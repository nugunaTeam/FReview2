package com.nuguna.freview.security.login;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.login.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
      throw new UsernameNotFoundException("email");
    }
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    UserCode userCode = UserCode.from(userVO.getCode());
    if(userCode.isAdmin()){
      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    } else if(userCode.isCustomer()){
      authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
    } else if(userCode.isStore()){
      authorities.add(new SimpleGrantedAuthority("ROLE_STORE"));
    }

    return new CustomUserDetail(email, userVO.getPassword(), authorities,userVO);
  }

  public void checkPassword(String shaPassword) {

    boolean passwordCheck = loginService.checkPassword(shaPassword);
    if(!passwordCheck) {
      throw new UsernameNotFoundException("password") {
      };
    }
  }
}
