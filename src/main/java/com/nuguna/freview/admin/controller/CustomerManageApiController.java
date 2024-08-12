package com.nuguna.freview.admin.controller;

import static com.nuguna.freview.admin.constant.ManagementPageConstant.CUSTOMER_MANAGEMENT_PAGE_SIZE;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerInfoDTO;
import com.nuguna.freview.admin.dto.response.page.CustomerManageResponseDTO;
import com.nuguna.freview.admin.service.AdminService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/customer")
public class CustomerManageApiController {
  private final AdminService adminService;

  @Autowired
  public CustomerManageApiController(AdminService adminService) { this.adminService = adminService; }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public CustomerManageResponseDTO getCustomerList(@RequestBody CustomerListRequestDTO requestDTO) {
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    String searchWord = requestDTO.getSearchWord();

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    List<CustomerInfoDTO> customerList = adminService.getCustomerList(previousUserSeq, searchWord, CUSTOMER_MANAGEMENT_PAGE_SIZE);
    boolean hasMore = customerList.size() == CUSTOMER_MANAGEMENT_PAGE_SIZE;
    CustomerManageResponseDTO responseDTO = new CustomerManageResponseDTO();
    responseDTO.setCustomerList(customerList);
    responseDTO.setHasMore(hasMore);

    return responseDTO;
  }

  @RequestMapping(value = "/{deleteUserSeq}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteCustomer(@PathVariable Long deleteUserSeq,
      @RequestParam String adminVerificationPW,
      @RequestParam Long adminSeq) {
    try {
      adminService.deleteUser(adminSeq, adminVerificationPW, deleteUserSeq);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    } catch (IllegalStateException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
