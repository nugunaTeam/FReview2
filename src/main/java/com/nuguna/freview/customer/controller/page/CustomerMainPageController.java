package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.common.vo.user.UserVO;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class CustomerMainPageController {

  @RequestMapping("/customer/main-page")
  public String customerMyBrandPage(Model model, HttpServletRequest request) {
    UserVO uvo = (UserVO) request.getAttribute("UserVO");

      log.info(uvo.toString());

      model.addAttribute("userVO", uvo);
      return "customer_main";
  }

}
