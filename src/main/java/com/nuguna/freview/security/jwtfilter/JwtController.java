package com.nuguna.freview.security.jwtfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class JwtController {

  @RequestMapping("/expired-token")
  public String expiredToken(){

    return "common-expiredtoken";
  }

}