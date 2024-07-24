package com.nuguna.freview.customer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonPageController {

  // TODO : 체험단, 사장님에 따라 다르게 랜더링 해주어야 함.
  @RequestMapping(value = "/brand/{userSeq}", method = RequestMethod.GET)
  public String customerOtherBrandPage(@PathVariable("userSeq") Long userSeq,
      @RequestParam("fromUserSeq") Long fromUserSeq) {

    return "customer-brand-info";
  }


}
