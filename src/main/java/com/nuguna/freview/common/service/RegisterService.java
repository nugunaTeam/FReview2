package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;

public interface RegisterService {
  boolean checkDuplicatedEmail(RegisterCheckIdRequestDTO registerCheckIdRequestDTO);
}