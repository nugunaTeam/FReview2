package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.response.RegisterCheckIdResponseDTO;
import com.nuguna.freview.common.service.RegisterService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthApiController {

  private RegisterService registerService;

  @Autowired
  AuthApiController(RegisterService registerService) {this.registerService = registerService;}



  @RequestMapping(value = "/api/auth/checkid", method = RequestMethod.POST)
  public int checkDuplicatedId(@Valid @RequestBody RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    log.info("아이디 중복 확인");
    log.info(registerCheckIdRequestDTO.getEmail());
    int result = registerService.checkDuplicatedEmail(registerCheckIdRequestDTO);
    log.info("이메일 중복 결과 "+result);
    RegisterCheckIdResponseDTO registerCheckIdResponseDTO = new RegisterCheckIdResponseDTO("사용가능한 아이디입니다");

    return result;
  }

  @RequestMapping(value = "/api/auth/sendEmail", method = RequestMethod.POST)
  public void checkDuplicatedId(@Valid @RequestBody RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    log.info("아이디 중복 확인");
    log.info(registerCheckIdRequestDTO.getEmail());
    int result = registerService.checkDuplicatedEmail(registerCheckIdRequestDTO);
    log.info("이메일 중복 결과 "+result);
    RegisterCheckIdResponseDTO registerCheckIdResponseDTO = new RegisterCheckIdResponseDTO("사용가능한 아이디입니다");


  }


}
