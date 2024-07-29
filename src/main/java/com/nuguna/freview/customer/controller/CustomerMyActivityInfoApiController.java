package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyLikedPostsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// TODO : 화면 렌더링 이후, AJAX 요청으로 현재 페이지에 해당하는 데이터들 5개씩 로드
// ( 좋아요한 글, 내가 찜한 스토어, 나를 찜한 스토어 )
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/my/activity-info")
public class CustomerMyActivityInfoApiController {

  private final CustomerMyActivityService customerMyActivityService;

  @RequestMapping("/my-liked-posts")
  public ResponseEntity<CustomerMyLikedPostsRetrieveResponseDTO> getMyLikedPosts(
      @RequestParam Long userSeq,
      @Valid @RequestBody CustomerMyLikedPostsRetrieveRequestDTO customerMyLikedPostsRetrieveRequestDTO) {
    CustomerMyLikedPostsRetrieveResponseDTO myLikedPosts = customerMyActivityService.getMyLikedPosts(
        userSeq, customerMyLikedPostsRetrieveRequestDTO);
    return new ResponseEntity<>(myLikedPosts, HttpStatus.OK);
  }

  @RequestMapping("/my-zzimed-customers")
  public ResponseEntity<CustomerMyZzimedStoresRetrieveResponseDTO> getMyZzimedStores(
      @RequestParam Long userSeq,
      @Valid @RequestBody CustomerMyZzimedStoresRetrieveRequestDTO customerMyZzimedStoresRetrieveRequestDTO) {
    CustomerMyZzimedStoresRetrieveResponseDTO myZzimedStores = customerMyActivityService.getMyZzimedStores(
        userSeq, customerMyZzimedStoresRetrieveRequestDTO);
    return new ResponseEntity<>(myZzimedStores, HttpStatus.OK);
  }

  @RequestMapping("/my-zzimed-stores")
  public ResponseEntity<CustomerMyZzimedCustomersResponseDTO> getMyZzimedCustomers(
      @RequestParam Long userSeq,
      @Valid @RequestBody CustomerMyZzimedCustomersRetrieveRequestDTO customerMyZzimedCustomersRetrieveRequestDTO) {
    CustomerMyZzimedCustomersResponseDTO myZzimedCustomers = customerMyActivityService.getMyZzimedCustomers(
        userSeq, customerMyZzimedCustomersRetrieveRequestDTO);
    return new ResponseEntity<>(myZzimedCustomers, HttpStatus.OK);
  }


}
