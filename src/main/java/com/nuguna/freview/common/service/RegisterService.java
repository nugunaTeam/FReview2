package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckNickNameRequestDTO;

public interface RegisterService {
  boolean checkDuplicatedEmail(RegisterCheckIdRequestDTO registerCheckIdRequestDTO);
  boolean checkDuplicatedNickName(RegisterCheckNickNameRequestDTO requestCheckNicknameRequestDTO);
}
