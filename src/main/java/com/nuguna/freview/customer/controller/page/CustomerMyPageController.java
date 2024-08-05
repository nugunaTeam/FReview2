package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/my")
public class CustomerMyPageController {

  private final CustomerPageService customerPageService;

  @Autowired
  public CustomerMyPageController(CustomerPageService customerPageService) {
    this.customerPageService = customerPageService;
  }

  @RequestMapping(value = "/brand-info", method = RequestMethod.GET)
  public String customerMyBrandPage(@RequestParam Long userSeq, Model model) {
    CustomerMyBrandPageInfoResponseDTO brandPageInfo = customerPageService.getBrandPageInfo(
        userSeq);
    model.addAttribute("brandInfo", brandPageInfo.getBrandInfo());
    model.addAttribute("reviewInfos", brandPageInfo.getReviewInfos());
    model.addAttribute("reviewPageInfo", brandPageInfo.getReviewPaginationInfo());
    model.addAttribute("userSeq", userSeq);
    return "customer-my-brand-info";
  }

  @RequestMapping(value = "/experience", method = RequestMethod.GET)
  public String customerMyExperiencePage(@RequestParam(required = false) Long userSeq) {
    return "customer-my-experience-info";
  }

  @RequestMapping(value = "/activity", method = RequestMethod.GET)
  public String customerMyActivityPage(@RequestParam(required = false) Long userSeq) {
    return "customer-my-activity-info";
  }

  @RequestMapping(value = "/notification", method = RequestMethod.GET)
  public String customerMyNotificationPage(@RequestParam(required = false) Long userSeq) {
    return "customer-my-notification";
  }

  @RequestMapping(value = "/personal-info", method = RequestMethod.GET)
  public String customerMyPersonalInfoPage(@RequestParam(required = false) Long userSeq) {
    return "customer-my-personal-info";
  }

}
