package com.nuguna.freview.security.jwtfilter;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class JwtController {

  @RequestMapping("/expired-token")
  public String expiredToken(Model model, HttpServletRequest request){

    return "common-expiredtoken";
  }

}