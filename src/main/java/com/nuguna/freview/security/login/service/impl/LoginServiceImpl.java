package com.nuguna.freview.security.login.service.impl;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.login.mapper.LoginMapper;
import com.nuguna.freview.security.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  LoginMapper loginMapper;

  @Autowired
  public void setLoginMapper(LoginMapper loginMapper) {
    this.loginMapper = loginMapper;
  }

  @Override
  public UserVO searchUserByID(String email) {

    return loginMapper.selectUserInfo(email);

  }

  @Override
  public boolean checkPassword(String shaPassword) {
    return loginMapper.selectCheckPassword(shaPassword);
  }
}
