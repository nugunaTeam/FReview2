package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.response.CustomerZzimedMeCustomersRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyNotificationService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/customer/my/notification")
public class CustomerMyNotificationInfoApiController {

  private final CustomerMyNotificationService customerMyNotificationService;

  @Autowired
  public CustomerMyNotificationInfoApiController(
      CustomerMyNotificationService customerMyNotificationService) {
    this.customerMyNotificationService = customerMyNotificationService;
  }

  @RequestMapping(value = "/zzimed-me-customers", method = RequestMethod.GET)
  public ResponseEntity<CustomerZzimedMeCustomersRetrieveResponseDTO> getZzimedMeCustomers(
      @RequestParam Boolean isRead,
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerZzimedMeCustomersRetrieveResponseDTO customerZzimedMeCustomersRetrieveResponseDTO = customerMyNotificationService.getZzimedMeCustomers(
        userSeq, isRead, targetPage);
    return new ResponseEntity<>(customerZzimedMeCustomersRetrieveResponseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/zzimed-me-stores", method = RequestMethod.GET)
  public ResponseEntity<CustomerZzimedMeStoresRetrieveResponseDTO> getZzimedMeStores(
      @RequestParam Boolean isRead,
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerZzimedMeStoresRetrieveResponseDTO customerZzimedMeStoresRetrieveResponseDTO = customerMyNotificationService.getZzimedMeStores(
        userSeq, isRead, targetPage);
    return new ResponseEntity<>(customerZzimedMeStoresRetrieveResponseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/{notificationSeq}", method = RequestMethod.POST)
  public ResponseEntity<Void> makeNotificationRead(
      @PathVariable("notificationSeq") Long notificationSeq) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    customerMyNotificationService.makeNotificationRead(userSeq, notificationSeq);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
