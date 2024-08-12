package com.nuguna.freview.common.service;

import com.nuguna.freview.OAuth.dto.request.GoogleUserRegistRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckBusinessNumberDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckNickNameRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterRequestDTO;

public interface RegisterService {
  boolean checkDuplicatedEmail(RegisterCheckIdRequestDTO registerCheckIdRequestDTO);
  boolean checkDuplicatedNickName(RegisterCheckNickNameRequestDTO requestCheckNicknameRequestDTO);
  void cutomerRegist(RegisterRequestDTO registerRequestDTO);
  boolean checkBusinessNumber(RegisterCheckBusinessNumberDTO registerCheckBusinessNumberDTO);
  void storeRegist(RegisterRequestDTO registerRequestDTO);
  void oAuthCustomerRegist(GoogleUserRegistRequestDTO googleUserRegistRequestDTO);
  void oAuthStoreRegist(GoogleUserRegistRequestDTO googleUserRegistRequestDTO);
}
