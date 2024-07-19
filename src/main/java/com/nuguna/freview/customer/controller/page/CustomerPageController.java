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

    log.info("reviewPagination INFO = {}", brandPageInfo.getReviewPaginationInfo());

    log.info(brandPageInfo.getReviewInfos().toString());
    log.info(brandPageInfo.getBrandInfo().toString());
    model.addAttribute("brandInfo", brandPageInfo.getBrandInfo());
    model.addAttribute("reviewInfos", brandPageInfo.getReviewInfos());
    model.addAttribute("reviewPageInfo", brandPageInfo.getReviewPaginationInfo());
    model.addAttribute("userSeq", userSeq);
    return "customer-my-brand-info";
  }

  @RequestMapping("/my/activity")
  public String customerMyActivity(@RequestParam(required = false) Long userSeq) {
    return "customer-my-activity-info";
  }

  @RequestMapping("/my/notification")
  public String customerMyNotification(@RequestParam(required = false) Long userSeq) {
    return "customer-my-notification";
  }

  @RequestMapping("/my/personal-info")
  public String customerMyPersonalInfo(@RequestParam(required = false) Long userSeq) {
    return "customer-my-personal-info";
  }

}
