package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.OAuth.dto.request.GoogleUserRegistRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckBusinessNumberDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckNickNameRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterRequestDTO;
import com.nuguna.freview.common.mapper.RegisterMapper;
import com.nuguna.freview.common.service.RegisterService;
import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.global.util.ShaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

  private final RegisterMapper registerMapper;
  private final ShaUtil shaUtil;
  @Autowired
  RegisterServiceImpl(RegisterMapper registerMapper, ShaUtil shaUtil){this.registerMapper = registerMapper;
                                                                      this.shaUtil = shaUtil;}

  @Override
  public boolean checkDuplicatedEmail(RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    boolean result = false;
    String email = registerCheckIdRequestDTO.getEmail();
    result = registerMapper.getDuplicatedEmail(email);
    return result;
  }

  @Override
  public boolean checkDuplicatedNickName(
      RegisterCheckNickNameRequestDTO requestCheckNicknameRequestDTO) {
    boolean result = false;
    String nickName = requestCheckNicknameRequestDTO.getNickname();
    result = registerMapper.getDuplicatedNickName(nickName);
    return result;
  }

  @Override
  public void cutomerRegist(RegisterRequestDTO registerRequestDTO) {
    String shaPassword = shaUtil.sha256Encoding(registerRequestDTO.getPassword());
    UserVO uvo = UserVO.builder()
        .email(registerRequestDTO.getEmail())
        .password(shaPassword)
        .subEmail(registerRequestDTO.getSubEmail())
        .nickname(registerRequestDTO.getNickname())
        .ageGroup(registerRequestDTO.getAgeGroup())
        .code(registerRequestDTO.getCode())
        .loginType("FORM")
        .isWithDrawn(false).build();
    registerMapper.insertCustomerInfo(uvo);
  }

  @Override
  public boolean checkBusinessNumber(
      RegisterCheckBusinessNumberDTO registerCheckBusinessNumberDTO) {
    boolean result = false;
    String businessNumber = registerCheckBusinessNumberDTO.getBuisnessNumber();
    result = registerMapper.getCheckBusinessNumber(businessNumber);
    return result;
  }

  @Override
  public void storeRegist(RegisterRequestDTO registerRequestDTO) {
    String shaPassword = shaUtil.sha256Encoding(registerRequestDTO.getPassword());
    UserVO uvo = UserVO.builder()
        .email(registerRequestDTO.getEmail())
        .password(shaPassword)
        .subEmail(registerRequestDTO.getSubEmail())
        .businessNumber(registerRequestDTO.getBusinessNumber())
        .storeLocation(registerRequestDTO.getStoreLocation())
        .code(registerRequestDTO.getCode())
        .ageGroup(registerRequestDTO.getAgeGroup())
        .loginType("FORM")
        .isWithDrawn(false).build();
    registerMapper.insertStoreInfo(uvo);
  }

  @Override
  public void oAuthCustomerRegist(GoogleUserRegistRequestDTO googleUserRegistRequestDTO) {
    UserVO uvo = UserVO.builder()
        .email(googleUserRegistRequestDTO.getEmail())
        .subEmail(googleUserRegistRequestDTO.getSubEmail())
        .nickname(googleUserRegistRequestDTO.getNickname())
        .ageGroup(googleUserRegistRequestDTO.getAgeGroup())
        .code(googleUserRegistRequestDTO.getCode())
        .loginType("GOOGLE")
        .isWithDrawn(false).build();
    registerMapper.insertOAuthCustomerInfo(uvo);
  }

  @Override
  public void oAuthStoreRegist(GoogleUserRegistRequestDTO googleUserRegistRequestDTO) {
    UserVO uvo = UserVO.builder()
        .email(googleUserRegistRequestDTO.getEmail())
        .subEmail(googleUserRegistRequestDTO.getSubEmail())
        .businessNumber(googleUserRegistRequestDTO.getBusinessNumber())
        .storeLocation(googleUserRegistRequestDTO.getStoreLocation())
        .code(googleUserRegistRequestDTO.getCode())
        .ageGroup(googleUserRegistRequestDTO.getAgeGroup())
        .loginType("GOOGLE")
        .isWithDrawn(false).build();
    registerMapper.insertOAuthStoreInfo(uvo);
  }
}
