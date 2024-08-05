package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.request.EmailModifyRequestDTO;
import com.nuguna.freview.admin.dto.request.PasswordModifyRequestDTO;
import com.nuguna.freview.admin.dto.response.page.AdminProfileDTO;
import com.nuguna.freview.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

  @RequestMapping(value = "/password-update", method = RequestMethod.POST)
  public HttpStatus updatePassword(@RequestBody PasswordModifyRequestDTO requestDTO) {
    Long userSeq = requestDTO.getUserSeq();
    String oldPassword = requestDTO.getOldPassword();
    String newPassword = requestDTO.getNewPassword();

    boolean isMatching = adminService.isPasswordValid(userSeq, oldPassword);
    if (isMatching) {
      adminService.updatePassword(userSeq, newPassword);
      return HttpStatus.OK;
    } else {
      return HttpStatus.UNAUTHORIZED;
    }
  }

  @RequestMapping(value = "/sub-email-update", method = RequestMethod.POST)
  public HttpStatus updateSubEmail(@RequestBody EmailModifyRequestDTO requestDTO) {
    Long userSeq = requestDTO.getUserSeq();
    String newEmail = requestDTO.getNewEmail();

      if (adminService.updateSubEmail(userSeq, newEmail)) {
        return HttpStatus.OK;
      } else {
        return HttpStatus.INTERNAL_SERVER_ERROR;
      }
  }
}