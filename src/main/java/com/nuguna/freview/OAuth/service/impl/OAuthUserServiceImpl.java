package com.nuguna.freview.OAuth.service.impl;

import com.nuguna.freview.OAuth.service.OAuthUserService;
import com.nuguna.freview.common.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthUserServiceImpl implements OAuthUserService {

  private final RegisterMapper registerMapper;

  @Autowired
  public OAuthUserServiceImpl(RegisterMapper registerMapper) {
    this.registerMapper = registerMapper;
  }

  @Override
  public boolean checkUser(String email) {
    return registerMapper.getDuplicatedEmail(email);
  }
}
