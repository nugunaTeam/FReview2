package com.nuguna.freview.security.login;

import com.nuguna.freview.common.vo.user.UserVO;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetail extends User {

  UserVO userVO;

  public CustomUserDetail(String username, String password,
      Collection<? extends GrantedAuthority> authorities,UserVO userVO) {
    super(username, password, authorities);
    this.userVO = userVO;
  }

  public UserVO getUserVO() {
    return userVO;
  }

  public void setUserVO(UserVO userVO) {
    this.userVO = userVO;
  }
}
