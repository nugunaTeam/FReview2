package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
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
@RequestMapping("/api/customer/review")
public class CustomerReviewApiController {

  private final CustomerReviewService customerReviewService;

  @Autowired
  public CustomerReviewApiController(CustomerReviewService customerReviewService) {
    this.customerReviewService = customerReviewService;
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public ResponseEntity<CustomerReviewRegisterResponseDTO> registerCustomerReview(
      @Valid @RequestBody CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO
  ) {
    CustomerReviewRegisterResponseDTO responseDTO = customerReviewService.registerCustomerReview(
        customerReviewRegisterRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

}
