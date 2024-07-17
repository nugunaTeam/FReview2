package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.mapper.RegisterMapper;
import com.nuguna.freview.common.service.RegisterService;
import com.nuguna.freview.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

  private final RegisterMapper registerMapper;

  @Autowired
  RegisterServiceImpl(RegisterMapper registerMapper){this.registerMapper = registerMapper;}

  @Override
  public boolean checkDuplicatedEmail(RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    int checkRow = 0;
    boolean result = false;
    String email = registerCheckIdRequestDTO.getEmail();
    log.info(email);
    checkRow = registerMapper.getDuplicatedEmail(email);
    if(checkRow == 0)
      result = true;
    log.info("서비스 결과 "+result);


    return result;
  }
}
