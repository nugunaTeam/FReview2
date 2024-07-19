package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
  int getDuplicatedEmail(String email);
  int getDuplicatedNickName(String nickName);
  void insertCustomerInfo(UserVO uvo);
  int getCheckBusinessNumber(String businessNumber);
  void insertStoreInfo(UserVO uvo);
}
