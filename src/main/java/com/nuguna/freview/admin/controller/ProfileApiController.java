package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.response.page.AdminProfileDTO;
import com.nuguna.freview.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/profile")
public class ProfileApiController {

  private final AdminService adminService;

  @Autowired
  public ProfileApiController(AdminService adminService) {
    this.adminService = adminService;
  }

  @RequestMapping(value = "/{userSeq}", method = RequestMethod.POST)
  public AdminProfileDTO viewProfile(@PathVariable Long userSeq) {
    return adminService.getAdminProfile(userSeq);
  }
}