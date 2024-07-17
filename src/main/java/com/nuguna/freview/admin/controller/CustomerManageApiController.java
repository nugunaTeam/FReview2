package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.request.CustomerManageRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerManageResponseDTO;
import com.nuguna.freview.admin.service.AdminService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  private final Integer LIMIT = 30;

  @Autowired
  public CustomerManageApiController(AdminService adminService) { this.adminService = adminService; }

  //HACK: 로그인 유저의 실제 seq 로 수정 필요
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public Map<String, Object> getCustomerList(@RequestParam(value = "previous_user_seq") Long previousUserSeq) {

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    CustomerManageRequestDTO customerManageRequestDTO = CustomerManageRequestDTO.builder()
        .previousUserSeq(previousUserSeq)
        .limit(LIMIT)
        .build();
    List<CustomerManageResponseDTO> customerList = adminService.getCustomerList(customerManageRequestDTO);
    boolean hasMore = customerList.size() == LIMIT;

    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("data", customerList);
    responseMap.put("hasMore", hasMore);

    return responseMap;
  }
}
