package com.nuguna.freview.security.jwtfilter.service;

import com.nuguna.freview.common.vo.user.UserVO;

public interface JwtUserService {

  UserVO searchUserByID(String email);
}
