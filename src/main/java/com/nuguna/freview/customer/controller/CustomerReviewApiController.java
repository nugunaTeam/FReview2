package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.service.CustomerReviewService;
import java.util.List;
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
@RequestMapping("/api/customer/review")
public class CustomerReviewApiController {

  private final CustomerReviewService customerReviewService;

  @Autowired
  public CustomerReviewApiController(CustomerReviewService customerReviewService) {
    this.customerReviewService = customerReviewService;
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public ResponseEntity<CustomerMyReviewRegisterResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO
  ) {
    CustomerMyReviewRegisterResponseDTO responseDTO = customerReviewService.registerCustomerReview(
        customerMyReviewRegisterRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.GET)
  public ResponseEntity<List<ReviewLogInfoDTO>> registerCustomerReview(
      @Valid @RequestBody CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO
  ) {
    List<ReviewLogInfoDTO> responseDTO = customerReviewService.getReviews(
        customerMyReviewsRetrieveRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

}
