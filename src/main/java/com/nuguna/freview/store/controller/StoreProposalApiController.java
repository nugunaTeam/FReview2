package com.nuguna.freview.store.controller;

import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.dto.request.StoreProposalToCustomerRequestDTO;
import com.nuguna.freview.customer.service.StoreProposalService;
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
@RequestMapping("/api/store")
public class StoreProposalApiController {

  private final StoreProposalService storeProposalService;

  @Autowired
  public StoreProposalApiController(StoreProposalService storeProposalService) {
    this.storeProposalService = storeProposalService;
  }

  @RequestMapping(value = "/proposal", method = RequestMethod.POST)
  public ResponseEntity<Void> proposeToCustomer(
      @Valid @RequestBody StoreProposalToCustomerRequestDTO storeProposalToCustomerRequestDTO) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    storeProposalService.makeProposalToCustomer(storeSeq, storeProposalToCustomerRequestDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
