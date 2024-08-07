package com.nuguna.freview.OAuth.service;

import com.nuguna.freview.OAuth.OAuthUserVO;

public interface OAuthUserService {

  boolean checkUser(String email);

  OAuthUserVO loadUserByUsername(String username);
}
