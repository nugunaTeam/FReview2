package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerZzimedMeStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeCustomersRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeStoresRetriveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyNotificationService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO : 찜( 나를 찜한 스토어, 나를 찜한 체험단 ) + 읽음 / 안읽음 나누기 + 안읽음 => 읽음 처리

@Slf4j
@RestController
@RequestMapping("/api/customer/my/notification")
public class CustomerMyNotificationApiController {

  private final CustomerMyNotificationService customerMyNotificationService;

  @Autowired
  public CustomerMyNotificationApiController(
      CustomerMyNotificationService customerMyNotificationService) {
    this.customerMyNotificationService = customerMyNotificationService;
  }

  @RequestMapping(value = "/zzimed-me-customers", method = RequestMethod.GET)
  public ResponseEntity<CustomerZzimedMeCustomersRetrieveResponseDTO> getZzimedMeCustomers(
      @RequestParam Long userSeq,
      @RequestParam Boolean isRead,
      @RequestParam Integer targetPage) {
    CustomerZzimedMeCustomersRetrieveResponseDTO customerZzimedMeCustomersRetrieveResponseDTO = customerMyNotificationService.getZzimedMeCustomers(
        userSeq, isRead, targetPage);
    return new ResponseEntity<>(customerZzimedMeCustomersRetrieveResponseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/zzimed-me-stores", method = RequestMethod.GET)
  public ResponseEntity<CustomerZzimedMeStoresRetriveResponseDTO> getZzimedMeStores(
      @RequestParam Long userSeq,
      @Valid @ModelAttribute CustomerZzimedMeStoresRetrieveRequestDTO customerZzimedMeStoresRetrieveRequestDTO) {
    CustomerZzimedMeStoresRetriveResponseDTO customerZzimedMeStoresRetriveResponseDTO = customerMyNotificationService.getZzimedMeStores(
        userSeq, customerZzimedMeStoresRetrieveRequestDTO);
    return new ResponseEntity<>(customerZzimedMeStoresRetriveResponseDTO, HttpStatus.OK);
  }

  // TODO : 읽음 버튼 클릭 시, AJAX 요청 => success 시, 뷰 읽음 처리 ( 페이지 리로딩 X )
  @RequestMapping(value = "/{notificationSeq}", method = RequestMethod.POST)
  public ResponseEntity<Void> makeNotificationRead(
      @RequestParam Long userSeq,
      @PathVariable("notificationSeq") Long notificationSeq) {
    customerMyNotificationService.makeNotificationRead(userSeq, notificationSeq);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
