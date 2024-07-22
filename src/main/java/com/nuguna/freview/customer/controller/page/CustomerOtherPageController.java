package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.customer.dto.request.ProposalToCustomerRequestDTO;
import com.nuguna.freview.customer.service.CustomerOtherPageService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerOtherPageController {

  private final CustomerOtherPageService customerOtherPageService;

  @Autowired
  public CustomerOtherPageController(CustomerOtherPageService customerOtherPageService) {
    this.customerOtherPageService = customerOtherPageService;
  }

  // TODO : 체험단, 사장님에 따라 다르게 랜더링 해주어야 함.
  @RequestMapping("/brand/{userSeq}")
  public String customerOtherBrandPage(@PathVariable("userSeq") Long userSeq) {
    return "customer-brand-info";
  }

  @ResponseBody
  @RequestMapping(value = "/api/other/customer/proposal", method = RequestMethod.POST)
  public ResponseEntity<Void> proposeToCustomer(
      @Valid @RequestBody ProposalToCustomerRequestDTO proposalToCustomerRequestDTO) {
    customerOtherPageService.makeProposalToCustomer(proposalToCustomerRequestDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }


}
