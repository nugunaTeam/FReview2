package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
  boolean getDuplicatedEmail(String email);
  boolean getDuplicatedNickName(String nickName);
  void insertCustomerInfo(UserVO uvo);
  boolean getCheckBusinessNumber(String businessNumber);
  void insertStoreInfo(UserVO uvo);
  void insertOAuthCustomerInfo(UserVO uvo);
  void insertOAuthStoreInfo(UserVO uvo);
}
