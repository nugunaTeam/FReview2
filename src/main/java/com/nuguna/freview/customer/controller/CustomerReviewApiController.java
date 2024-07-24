package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerReviewService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerReviewApiController {

  private final CustomerReviewService reviewService;

  @Autowired
  public CustomerReviewApiController(CustomerReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public ResponseEntity<CustomerMyReviewRegisterResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO
  ) {
    CustomerMyReviewRegisterResponseDTO responseDTO = reviewService.registerCustomerReview(
        customerMyReviewRegisterRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.POST)
  public ResponseEntity<CustomerMyReviewsRetrieveResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO
  ) {
    CustomerMyReviewsRetrieveResponseDTO responseDTO = reviewService.getCustomerMyReviews(
        customerMyReviewsRetrieveRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
