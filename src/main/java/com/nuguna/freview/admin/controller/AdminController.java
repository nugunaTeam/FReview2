package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.admin.vo.AdminVO;
import com.nuguna.freview.common.vo.user.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  //HACK: 로그인 유저의 실제 seq 로 수정 필요
  @RequestMapping(value = "/manage/customer", method = RequestMethod.GET)
  public String adminPage(@RequestParam("user_seq") Long userSeq, Model model) {
    AdminVO loginUser = adminService.getAdminById(userSeq);

    if (loginUser.getCode() != UserCode.ADMIN.getCode()) {
      return "common-error-404";
    }

    model.addAttribute("loginUser", loginUser);
    return "admin-management-customer";
  }
}