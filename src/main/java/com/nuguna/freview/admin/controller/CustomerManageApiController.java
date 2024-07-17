package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.dto.response.page.CustomerManageResponseDTO;
import com.nuguna.freview.admin.service.AdminService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/customer")
public class CustomerManageApiController {

  private final AdminService adminService;
  private final Integer PAGE_SIZE = 30;

  @Autowired
  public CustomerManageApiController(AdminService adminService) { this.adminService = adminService; }

  //HACK: 로그인 유저의 실제 seq 로 수정 필요
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public CustomerManageResponseDTO getCustomerList(@RequestParam(value = "previous_user_seq") Long previousUserSeq) {

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    CustomerListRequestDTO customerListRequestDTO = CustomerListRequestDTO.builder()
        .previousUserSeq(previousUserSeq)
        .limit(PAGE_SIZE)
        .build();
    List<CustomerListDTO> customerList = adminService.getCustomerList(customerListRequestDTO);
    boolean hasMore = customerList.size() == PAGE_SIZE;
    CustomerManageResponseDTO responseDTO = CustomerManageResponseDTO.builder()
        .customerList(customerList)
        .hasMore(hasMore)
        .build();

    return responseDTO;
  }
}
