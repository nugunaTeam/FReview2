package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.response.CustomerAcceptedProposalToMeInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProposalToMeInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyExperienceService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer/my/experience")
public class CustomerMyExperienceInfoApiController {

  private final CustomerMyExperienceService customerMyExperienceService;

  @Autowired
  public CustomerMyExperienceInfoApiController(
      CustomerMyExperienceService customerMyExperienceService) {
    this.customerMyExperienceService = customerMyExperienceService;
  }

  @RequestMapping(value = "/apply-list", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyApplyInfosRetrieveResponseDTO> getMyApplyInfos(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyApplyInfosRetrieveResponseDTO myApplyInfos = customerMyExperienceService.getMyApplyInfos(
        userSeq, targetPage);
    return new ResponseEntity<>(myApplyInfos, HttpStatus.OK);
  }

  @RequestMapping(value = "/proposal-list", method = RequestMethod.GET)
  public ResponseEntity<CustomerProposalToMeInfosRetrieveResponseDTO> getProposalToMeInfos(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerProposalToMeInfosRetrieveResponseDTO proposalToMeInfos = customerMyExperienceService.getProposalToMeInfos(
        userSeq, targetPage);
    return new ResponseEntity<>(proposalToMeInfos, HttpStatus.OK);
  }

  @RequestMapping(value = "/{experienceSeq}/accept", method = RequestMethod.POST)
  public ResponseEntity<Void> acceptProposalToMe(
      @PathVariable("experienceSeq") Long experienceSeq) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    customerMyExperienceService.acceptProposalToMe(userSeq, experienceSeq);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/{experienceSeq}/reject", method = RequestMethod.POST)
  public ResponseEntity<Void> rejectProposalToMe(
      @PathVariable("experienceSeq") Long experienceSeq) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    customerMyExperienceService.rejectProposalToMe(userSeq, experienceSeq);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/accepted-apply-list", method = RequestMethod.GET)
  public ResponseEntity<CustomerMyAcceptedApplyInfosRetrieveResponseDTO> getMyAcceptedApplyInfos(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyAcceptedApplyInfosRetrieveResponseDTO myAcceptedApplyInfos = customerMyExperienceService.getMyAcceptedApplyInfos(
        userSeq, targetPage);
    return new ResponseEntity<>(myAcceptedApplyInfos, HttpStatus.OK);
  }

  @RequestMapping(value = "/accepted-proposal-list", method = RequestMethod.GET)
  public ResponseEntity<CustomerAcceptedProposalToMeInfosRetrieveResponseDTO> getMyAcceptedProposalInfos(
      @RequestParam Integer targetPage) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerAcceptedProposalToMeInfosRetrieveResponseDTO myAcceptedProposalInfos = customerMyExperienceService.getMyAcceptedProposalInfos(
        userSeq, targetPage);
    return new ResponseEntity<>(myAcceptedProposalInfos, HttpStatus.OK);
  }


}
