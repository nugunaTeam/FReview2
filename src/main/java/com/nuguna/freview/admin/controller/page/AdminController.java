package com.nuguna.freview.admin.controller.page;

import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import java.time.YearMonth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String adminHome() {
    return "redirect:/admin/analysis";
  }

  @RequestMapping(value = "/manage/customer", method = RequestMethod.GET)
  public String customerManagePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "admin-management-customer";
  }

  @RequestMapping(value = "/manage/store", method = RequestMethod.GET)
  public String storeManagePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "admin-management-store";
  }

  @RequestMapping(value = "/manage/experience", method = RequestMethod.GET)
  public String experienceManagePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "admin-management-experience";
  }

  @RequestMapping(value = "/analysis", method = RequestMethod.GET)
  public String analysisManagePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    YearMonth currentYearMonth = YearMonth.now();
    String currentMonth = currentYearMonth.toString();

    model.addAttribute("loginUser", loginUser);
    model.addAttribute("currentMonth", currentMonth);

    return "admin-analysis";
  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String profileManagePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "admin-personal-profile";
  }
}