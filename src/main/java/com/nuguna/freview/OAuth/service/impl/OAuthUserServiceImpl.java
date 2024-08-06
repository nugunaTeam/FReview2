package com.nuguna.freview.OAuth.service.impl;

import com.nuguna.freview.OAuth.OAuthUserVO;
import com.nuguna.freview.OAuth.service.OAuthUserService;
import com.nuguna.freview.common.mapper.RegisterMapper;
import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.login.CustomUserDetail;
import com.nuguna.freview.security.login.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OAuthUserServiceImpl implements OAuthUserService {

  private final RegisterMapper registerMapper;
  final LoginService loginService;

  @Autowired
  public OAuthUserServiceImpl(RegisterMapper registerMapper, LoginService loginService) {
    this.registerMapper = registerMapper;
    this.loginService = loginService;
  }

  @Override
  public boolean checkUser(String email) {
    return registerMapper.getDuplicatedEmail(email);
  }

  @Override
  public OAuthUserVO loadUserByUsername(String email) {
    UserVO userVO = loginService.searchUserByID(email);
    if(userVO == null) {
      throw new UsernameNotFoundException("email");
    }
    String role = "";

    UserCode userCode = UserCode.from(userVO.getCode());
    if(userCode.isAdmin()){
      role = "ROLE_ADMIN";
    } else if(userCode.isCustomer()){
      role = "ROLE_CUSTOMER";
    } else if(userCode.isStore()){
      role = "ROLE_STORE";
    }

    return new OAuthUserVO(userVO,role);
  }
}
