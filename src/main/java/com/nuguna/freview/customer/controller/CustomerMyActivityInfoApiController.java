package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/customer/my/activity-info")
public class CustomerMyActivityInfoApiController {

  private final CustomerMyActivityService customerMyActivityService;

  @Autowired
  public CustomerMyActivityInfoApiController(CustomerMyActivityService customerMyActivityService) {
    this.customerMyActivityService = customerMyActivityService;
  }

  @RequestMapping(value = "/my-liked-posts", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyLikedPostsRetrieveResponseDTO> getMyLikedPosts(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyLikedPostsRetrieveResponseDTO myLikedPosts = customerMyActivityService.getMyLikedPosts(
        userSeq, targetPage);
    return new ResponseEntity<>(myLikedPosts, HttpStatus.OK);
  }

  @RequestMapping(value = "/my-zzimed-stores", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyZzimedStoresRetrieveResponseDTO> getMyZzimedStores(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyZzimedStoresRetrieveResponseDTO myZzimedStores = customerMyActivityService.getMyZzimedStores(
        userSeq, targetPage);
    return new ResponseEntity<>(myZzimedStores, HttpStatus.OK);
  }

  @RequestMapping(value = "/my-zzimed-customers", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyZzimedCustomersResponseDTO> getMyZzimedCustomers(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyZzimedCustomersResponseDTO myZzimedCustomers = customerMyActivityService.getMyZzimedCustomers(
        userSeq, targetPage);
    return new ResponseEntity<>(myZzimedCustomers, HttpStatus.OK);
  }


}
