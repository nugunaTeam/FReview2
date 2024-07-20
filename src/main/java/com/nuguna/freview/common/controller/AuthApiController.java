package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.RegisterCheckBusinessNumberDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterCheckNickNameRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterSendEmailRequestDTO;
import com.nuguna.freview.common.dto.response.RegisterCheckInfoResponseDTO;
import com.nuguna.freview.common.dto.response.RegisterSendEmailResponseDTO;
import com.nuguna.freview.common.service.RegisterService;
import com.nuguna.freview.global.util.SendMailUtil;
import java.util.Properties;
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
public class AuthApiController {

  private RegisterService registerService;
  private SendMailUtil sendMailUtil;

  @Autowired
  public AuthApiController(RegisterService registerService, SendMailUtil sendEmail) {this.registerService = registerService; }

  @RequestMapping(value = "/api/auth/check-id", method = RequestMethod.POST)
  public ResponseEntity<RegisterCheckInfoResponseDTO> checkDuplicatedId(@Valid @RequestBody RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    log.info("아이디 중복 확인");
    log.info(registerCheckIdRequestDTO.getEmail());
    boolean result = registerService.checkDuplicatedEmail(registerCheckIdRequestDTO);
    log.info("이메일 중복 결과 "+result);

    RegisterCheckInfoResponseDTO registerCheckInfoResponseDTO = new RegisterCheckInfoResponseDTO(result);

    return new ResponseEntity<>(registerCheckInfoResponseDTO,HttpStatus.OK);
  }

  @RequestMapping(value = "/api/auth/send-randomNumber-toEmail", method = RequestMethod.POST)
  public ResponseEntity<RegisterSendEmailResponseDTO> sendEmail(@Valid @RequestBody RegisterSendEmailRequestDTO registerSendEmailRequestDTO) {

    log.info("이메일 보내기 확인");
    log.info(registerSendEmailRequestDTO.getEmail());
    log.info(registerSendEmailRequestDTO.getRandomNumber());

    String randomNumber = registerSendEmailRequestDTO.getRandomNumber();
    String toEmail = registerSendEmailRequestDTO.getEmail();


    String title = "[FReview] 이메일 인증번호 확인";
    String content = "인증번호는 "+randomNumber +" 입니다";

    sendMailUtil.goMail(sendMailUtil.setting(new Properties()),title,content,toEmail);

    RegisterSendEmailResponseDTO registerSendEmailResponseDTO = new RegisterSendEmailResponseDTO(randomNumber);
    return new ResponseEntity<>(registerSendEmailResponseDTO,HttpStatus.OK);

  }


  @RequestMapping(value = "/api/auth/nickname-check", method = RequestMethod.POST)
  public ResponseEntity<RegisterCheckInfoResponseDTO> checkDuplicatedNick(@Valid @RequestBody
      RegisterCheckNickNameRequestDTO requestCheckNicknameRequestDTO) {
    log.info("닉네임 중복 확인");
    log.info(requestCheckNicknameRequestDTO.getNickname());

    boolean result = registerService.checkDuplicatedNickName(requestCheckNicknameRequestDTO);
    log.info("이메일 중복 결과 "+result);
   RegisterCheckInfoResponseDTO registerCheckInfoResponseDTO = new RegisterCheckInfoResponseDTO(result);

   return new ResponseEntity<>(registerCheckInfoResponseDTO,HttpStatus.OK);
  }

  @RequestMapping(value = "/api/auth/register", method = RequestMethod.POST)
  public void register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
    log.info("닉네임 중복 확인");
    log.info(registerRequestDTO.getCode());
    if(registerRequestDTO.getCode().equals("CUSTOMER")){
      registerService.cutomerRegist(registerRequestDTO);
    }else if(registerRequestDTO.getCode().equals("STORE")){
      registerService.storeRegist(registerRequestDTO);
    }
  }

  @RequestMapping(value = "/api/auth/business-number-check", method = RequestMethod.POST)
  public ResponseEntity<RegisterCheckInfoResponseDTO> checkBuisnessNumber(@Valid @RequestBody RegisterCheckBusinessNumberDTO registerCheckBusinessNumberDTO) {
    log.info("사업자번호 확인");
    log.info(registerCheckBusinessNumberDTO.getBuisnessNumber());
    boolean result = registerService.checkBusinessNumber(registerCheckBusinessNumberDTO);
    RegisterCheckInfoResponseDTO registerCheckInfoResponseDTO = new RegisterCheckInfoResponseDTO(result);
    return new ResponseEntity<>(registerCheckInfoResponseDTO,HttpStatus.OK);
  }
}
