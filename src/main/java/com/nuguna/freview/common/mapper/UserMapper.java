package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  void insertCustomer(UserVO uservo);
}
