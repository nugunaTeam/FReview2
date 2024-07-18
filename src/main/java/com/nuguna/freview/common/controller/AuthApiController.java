package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.RegisterCheckIdRequestDTO;
import com.nuguna.freview.common.dto.request.RegisterSendEmailRequestDTO;
import com.nuguna.freview.common.dto.response.RegisterCheckIdResponseDTO;
import com.nuguna.freview.common.dto.response.RegisterSendEmailResponseDTO;
import com.nuguna.freview.common.service.RegisterService;
import com.nuguna.freview.global.util.SendMailUtil;
import com.nuguna.freview.global.util.ShaUtil;
import java.io.PrintWriter;
import java.util.Properties;
import javax.script.ScriptContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
  private SendMailUtil sendMailUtil;

  @Autowired
  AuthApiController(RegisterService registerService, SendMailUtil sendEmail) {this.registerService = registerService;
                                                                            this.sendMailUtil = sendEmail;}



  @RequestMapping(value = "/api/auth/checkid", method = RequestMethod.POST)
  public ResponseEntity<RegisterCheckIdResponseDTO> checkDuplicatedId(@Valid @RequestBody RegisterCheckIdRequestDTO registerCheckIdRequestDTO) {
    log.info("아이디 중복 확인");
    log.info(registerCheckIdRequestDTO.getEmail());
    boolean result = registerService.checkDuplicatedEmail(registerCheckIdRequestDTO);
    log.info("이메일 중복 결과 "+result);

    RegisterCheckIdResponseDTO registerCheckIdResponseDTO = new RegisterCheckIdResponseDTO(result);

    return new ResponseEntity<>(registerCheckIdResponseDTO,HttpStatus.OK);
  }

  @RequestMapping(value = "/api/auth/sendEmail", method = RequestMethod.POST)
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


}
