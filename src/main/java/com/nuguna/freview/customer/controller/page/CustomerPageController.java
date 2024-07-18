package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class CustomerPageController {

  private final CustomerPageService customerPageService;

  @Autowired
  public CustomerPageController(CustomerPageService customerPageService) {
    this.customerPageService = customerPageService;
  }

  @RequestMapping("/my/brand-info")
  public String customerMyBrandPage(@RequestParam Long userSeq, Model model) {
    CustomerMyBrandPageInfoResponseDTO brandPageInfo = customerPageService.getBrandPageInfo(
        userSeq);
    model.addAttribute("brandInfo", brandPageInfo);
    model.addAttribute("userSeq", userSeq);
    return "customer-my-brand-info";
  }

}
