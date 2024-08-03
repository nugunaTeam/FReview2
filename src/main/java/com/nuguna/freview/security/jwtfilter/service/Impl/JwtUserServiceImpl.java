package com.nuguna.freview.security.jwtfilter.service.Impl;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.service.JwtUserService;
import com.nuguna.freview.security.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtUserServiceImpl implements JwtUserService {

  LoginMapper loginMapper;

  @Autowired
  JwtUserServiceImpl(LoginMapper loginMapper) {
    this.loginMapper = loginMapper;
  }

  @Override
  public UserVO searchUserByID(String email) {
    return loginMapper.selectUserInfo(email);
  }
}
