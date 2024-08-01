package com.nuguna.freview.admin.controller.page;

import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.admin.vo.AdminVO;
import com.nuguna.freview.common.vo.user.UserCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String adminHome(Model model) {
    return "redirect:/admin/manage/customer";
  }

  @RequestMapping(value = "/manage/customer", method = RequestMethod.GET)
  public String customerManagePage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    AdminVO loginUser = adminService.getAdminById(userSeq);
    UserCode currentCode = UserCode.from(loginUser.getCode());

    if (!currentCode.isAdmin()) {
      return "common-error-404";
    }
    model.addAttribute("loginUser", loginUser);

    return "admin-management-customer";
  }

  @RequestMapping(value = "/manage/store", method = RequestMethod.GET)
  public String storeManagePage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    AdminVO loginUser = adminService.getAdminById(userSeq);
    UserCode currentCode = UserCode.from(loginUser.getCode());

    if (!currentCode.isAdmin()) {
      return "common-error-404";
    }
    model.addAttribute("loginUser", loginUser);

    return "admin-management-store";
  }

  @RequestMapping(value = "/manage/experience", method = RequestMethod.GET)
  public String experienceManagePage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    AdminVO loginUser = adminService.getAdminById(userSeq);
    UserCode currentCode = UserCode.from(loginUser.getCode());

    if (!currentCode.isAdmin()) {
      return "common-error-404";
    }
    model.addAttribute("loginUser", loginUser);

    return "admin-management-experience";
  }
}