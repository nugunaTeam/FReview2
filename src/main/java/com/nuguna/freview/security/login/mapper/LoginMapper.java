package com.nuguna.freview.security.login.mapper;

import com.nuguna.freview.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
  UserVO selectUserInfo(String email);
  boolean selectCheckPassword(String shaPassword);
}
