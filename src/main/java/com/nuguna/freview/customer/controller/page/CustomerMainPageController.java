package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import com.nuguna.freview.security.login.CustomUserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class CustomerMainPageController {

  @RequestMapping("/customer/main-page")
  public String customerMyBrandPage(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
    UserVO userVO = customUserDetail.getUserVO();
    log.info(userVO.toString());
    return "customer_main";
  }

}
