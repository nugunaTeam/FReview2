package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.request.CustomerSignupRequestDTO;
import com.nuguna.freview.common.vo.user.UserVO;

public interface UserService {

  void signup(CustomerSignupRequestDTO customerSignupRequestDTO);
  UserVO getUserInfo(Long userSeq);
  boolean withdrawalUser(Long userSeq);
}
