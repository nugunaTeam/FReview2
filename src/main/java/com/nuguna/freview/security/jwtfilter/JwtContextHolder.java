package com.nuguna.freview.security.jwtfilter;

import com.nuguna.freview.common.vo.user.UserVO;

public class JwtContextHolder {
  private static final ThreadLocal<UserVO> contextHolder = new ThreadLocal<>();

  public static void setUserVO(UserVO userVO) {
    contextHolder.set(userVO);
  }

  public static UserVO getUserVO() {
    return contextHolder.get();
  }

  public static void clear() {
    contextHolder.remove();
  }
}


