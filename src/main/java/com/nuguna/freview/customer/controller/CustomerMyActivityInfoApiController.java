package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// TODO : 화면 렌더링 이후, AJAX 요청으로 현재 페이지에 해당하는 데이터들 5개씩 로드
// ( 좋아요한 글, 내가 찜한 스토어, 나를 찜한 스토어 )
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
      @RequestParam Long userSeq,
      @RequestParam Integer targetPage) {
    CustomerMyLikedPostsRetrieveResponseDTO myLikedPosts = customerMyActivityService.getMyLikedPosts(
        userSeq, targetPage);
    return new ResponseEntity<>(myLikedPosts, HttpStatus.OK);
  }

  @RequestMapping(value = "/my-zzimed-stores", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyZzimedStoresRetrieveResponseDTO> getMyZzimedStores(
      @RequestParam Long userSeq,
      @RequestParam Integer targetPage) {
    CustomerMyZzimedStoresRetrieveResponseDTO myZzimedStores = customerMyActivityService.getMyZzimedStores(
        userSeq, targetPage);
    return new ResponseEntity<>(myZzimedStores, HttpStatus.OK);
  }

  @RequestMapping(value = "/my-zzimed-customers", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyZzimedCustomersResponseDTO> getMyZzimedCustomers(
      @RequestParam Long userSeq,
      @RequestParam Integer targetPage) {
    CustomerMyZzimedCustomersResponseDTO myZzimedCustomers = customerMyActivityService.getMyZzimedCustomers(
        userSeq, targetPage);
    return new ResponseEntity<>(myZzimedCustomers, HttpStatus.OK);
  }


}