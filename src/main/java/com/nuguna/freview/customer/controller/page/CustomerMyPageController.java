package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import com.nuguna.freview.customer.service.OtherBrandPageUtilService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
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
  private final OtherBrandPageUtilService otherBrandPageUtilService;

  @Autowired
  public CustomerMyPageController(CustomerPageService customerPageService,
      OtherBrandPageUtilService otherBrandPageUtilService) {
    this.customerPageService = customerPageService;
    this.otherBrandPageUtilService = otherBrandPageUtilService;
  }

  @RequestMapping(value = "/brand-info", method = RequestMethod.GET)
  public String customerMyBrandPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    Long userSeq = loginUser.getSeq();
    CustomerMyBrandPageInfoResponseDTO brandPageInfo = customerPageService.getBrandPageInfo(
        userSeq);
    model.addAttribute("brandInfo", brandPageInfo.getBrandInfo());
    model.addAttribute("reviewInfos", brandPageInfo.getReviewInfos());
    model.addAttribute("reviewPageInfo", brandPageInfo.getReviewPaginationInfo());
    model.addAttribute("userSeq", userSeq);
    model.addAttribute("loginUser", loginUser);
    return "customer-my-brand-info";
  }

  @RequestMapping(value = "/experience", method = RequestMethod.GET)
  public String customerMyExperiencePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    String nickname = otherBrandPageUtilService.getUserNickname(userSeq);
    model.addAttribute("nickname", nickname);
    model.addAttribute("userSeq", userSeq);
    model.addAttribute("loginUser", loginUser);
    return "customer-my-experience-info";
  }

  @RequestMapping(value = "/activity", method = RequestMethod.GET)
  public String customerMyActivityPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    String nickname = otherBrandPageUtilService.getUserNickname(userSeq);
    model.addAttribute("nickname", nickname);
    model.addAttribute("userSeq", userSeq);
    model.addAttribute("loginUser", loginUser);
    return "customer-my-activity-info";
  }

  @RequestMapping(value = "/notification", method = RequestMethod.GET)
  public String customerMyNotificationPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    String nickname = otherBrandPageUtilService.getUserNickname(userSeq);
    model.addAttribute("nickname", nickname);
    model.addAttribute("userSeq", userSeq);
    model.addAttribute("loginUser", loginUser);
    return "customer-my-notification-info";
  }

  @RequestMapping(value = "/personal-info", method = RequestMethod.GET)
  public String customerMyPersonalInfoPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    String nickname = otherBrandPageUtilService.getUserNickname(userSeq);
    model.addAttribute("nickname", nickname);
    model.addAttribute("userSeq", userSeq);
    model.addAttribute("loginUser", loginUser);
    return "customer-my-personal-info";
  }

}
