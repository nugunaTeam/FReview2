package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.request.CustomerSignupRequestDTO;
import com.nuguna.freview.common.mapper.UserMapper;
import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Autowired
  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  @Transactional
  public void signup(CustomerSignupRequestDTO customerSignupRequestDTO) {
    log.info("UserServiceImpl - signup");
    UserVO uvo = UserVO.builder()
        .nickname(customerSignupRequestDTO.getNickname())
        .code(customerSignupRequestDTO.getCode())
        .email(customerSignupRequestDTO.getEmail())
        .password(customerSignupRequestDTO.getPassword())
        .ageGroup(customerSignupRequestDTO.getAgeGroup())
        .subEmail(customerSignupRequestDTO.getSubEmail())
        .loginType("FORM")
        .build();
    userMapper.insertCustomer(uvo);
  }
}
