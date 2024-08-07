package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  void insertCustomer(UserVO uservo);
  UserVO selectUser(@Param("userSeq") Long userSeq);
  int deleteUser(Long userSeq);
}
