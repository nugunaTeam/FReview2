package com.nuguna.freview.security.login.service;

import com.nuguna.freview.common.vo.user.UserVO;

public interface LoginService {

  UserVO searchUserByID(String email);
}
