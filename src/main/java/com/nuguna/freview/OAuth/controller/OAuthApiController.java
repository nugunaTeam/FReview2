package com.nuguna.freview.OAuth.controller;

import com.nuguna.freview.OAuth.dto.request.GoogleUserRegistRequestDTO;
import com.nuguna.freview.common.service.RegisterService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OAuthApiController {

  private final RegisterService registerService;

  @Autowired
  public OAuthApiController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @RequestMapping(value = "/api/google/register", method = RequestMethod.POST)
  public void register(@Valid @RequestBody GoogleUserRegistRequestDTO googleUserRegistRequestDTO){

    log.info("구글유저 회원가입");
    if(googleUserRegistRequestDTO.getCode().equals("CUSTOMER")){
      registerService.oAuthCustomerRegist(googleUserRegistRequestDTO);
    }else if(googleUserRegistRequestDTO.getCode().equals("STORE")){
      registerService.oAuthStoreRegist(googleUserRegistRequestDTO);
    }

  }

}
