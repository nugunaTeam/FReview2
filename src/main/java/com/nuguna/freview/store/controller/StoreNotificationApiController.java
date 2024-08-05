package com.nuguna.freview.store.controller;

import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposalResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/store/notification")
public class StoreNotificationApiController {
  private final StoreNotificationPageService storeNotificationPageService;

  @Autowired
  public StoreNotificationApiController(StoreNotificationPageService storeNotificationPageService) {
    this.storeNotificationPageService = storeNotificationPageService;
  }

  @RequestMapping(value = "/received-like", method = RequestMethod.GET)
  public StoreNotificationReceivedLikeResponseDTO storeNotificationReceivedLike(
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer currentPage) throws IllegalPageAccessException {
    return storeNotificationPageService.storeNotificationReceivedLike(userSeq, currentPage);
  }

  @RequestMapping(value = "/received-zzim-customer", method = RequestMethod.GET)
  public StoreNotificationReceivedZzimCustomerResponseDTO storeNotificationReceivedZzimCustomer (
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer currentPage) throws IllegalPageAccessException {

    return storeNotificationPageService.storeNotificationReceivedZzimCustomer(userSeq, currentPage);
  }

  @RequestMapping(value = "/received-zzim-store", method = RequestMethod.GET)
  public StoreNotificationReceivedZzimStoreResponseDTO storeNotificationReceivedZzimStore (
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer currentPage) throws IllegalPageAccessException {

      return storeNotificationPageService.storeNotificationReceivedZzimStore(userSeq, currentPage);
  }

  @RequestMapping(value = "/experience-apply", method = RequestMethod.GET)
  public StoreNotificationExperienceApplyResponseDTO storeNotificationExperienceApply(
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer currentPage) {

      return storeNotificationPageService.storeNotificationExperienceApply(userSeq, currentPage);
  }

  @RequestMapping(value = "/experience-proposal", method = RequestMethod.GET)
  public StoreNotificationExperienceProposalResponseDTO storeNotificationExperienceProposal(
      @RequestParam("userSeq") Long userSeq, @RequestParam Integer currentPage) {
    return storeNotificationPageService.storeNotificationExperienceProposal(userSeq, currentPage);
  }

}
