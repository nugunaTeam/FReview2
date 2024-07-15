package com.nuguna.freview;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    log.info("hello!");
    return "index";
  }

}
