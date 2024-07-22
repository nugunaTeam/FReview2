package com.nuguna.freview.customer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOtherPageController {

  // TODO : 체험단, 사장님에 따라 다르게 랜더링 해주어야 함.
  @RequestMapping("/brand/{userSeq}")
  public String customerOtherBrandPage(@PathVariable("userSeq") Long userSeq) {
    return "customer-brand-info";
  }


}
