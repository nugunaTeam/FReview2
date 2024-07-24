package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.ProposalToCustomerRequestDTO;
import com.nuguna.freview.customer.service.CustomerProposalService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/other/customer")
public class CustomerProposalApiController {

  private final CustomerProposalService customerProposalService;

  @Autowired
  public CustomerProposalApiController(CustomerProposalService customerProposalService) {
    this.customerProposalService = customerProposalService;
  }

  @RequestMapping(value = "/proposal", method = RequestMethod.POST)
  public ResponseEntity<Void> proposeToCustomer(
      @Valid @RequestBody ProposalToCustomerRequestDTO proposalToCustomerRequestDTO) {
    customerProposalService.makeProposalToCustomer(proposalToCustomerRequestDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
