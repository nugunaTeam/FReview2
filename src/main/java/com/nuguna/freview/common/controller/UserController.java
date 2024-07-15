package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.CustomerSignupRequestDTO;
import com.nuguna.freview.common.dto.response.CustomerSignupResponseDTO;
import com.nuguna.freview.common.service.UserService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/api/common/signup/form/customer", method = RequestMethod.POST)
  public ResponseEntity<?> signup(
      @Valid @RequestBody CustomerSignupRequestDTO customerSignupRequestDTO) {
    log.info("체험단 회원 가입 진행");
    userService.signup(customerSignupRequestDTO);
    CustomerSignupResponseDTO customerSignupResponseDTO = new CustomerSignupResponseDTO(
        "폼 회원 가입이 완료되었습니다.");
    return new ResponseEntity<>(customerSignupResponseDTO, HttpStatus.OK);
  }
  
}
