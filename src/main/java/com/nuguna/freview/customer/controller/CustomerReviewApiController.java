package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.service.ReviewService;
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

  private final ReviewService reviewService;

  @Autowired
  public CustomerReviewApiController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public ResponseEntity<CustomerReviewRegisterResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO
  ) {
    log.info("registerCustomerReview 들어옴");
    CustomerReviewRegisterResponseDTO responseDTO = reviewService.registerCustomerReview(
        customerReviewRegisterRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.POST)
  public ResponseEntity<CustomerMyReviewsRetrieveResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO
  ) {
    CustomerMyReviewsRetrieveResponseDTO responseDTO = reviewService.getCustomerMyReviews(
        customerMyReviewsRetrieveRequestDTO);
    log.info("{}", responseDTO.getReviewPageInfo().toString());
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
