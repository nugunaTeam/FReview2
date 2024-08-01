package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.request.page.StoreNotificationPageRequestDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceListResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
  public List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedLikeResponseDTO> receivedLike = storeNotificationPageService.storeNotificationReceivedLike(userSeq);
    return receivedLike;
  }

  @RequestMapping(value = "/received-zzim", method = RequestMethod.GET)
  public StoreNotificationReceivedZzimResponseDTO receivedZzimList (@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedZzimCustomerResponseDTO> receivedZzimCustomer = storeNotificationPageService.storeNotificationReceivedZzimCustomer(userSeq);
    List<StoreNotificationReceivedZzimStoreResponseDTO> receivedZzimStore = storeNotificationPageService.storeNotificationReceivedZzimStore(userSeq);
    StoreNotificationReceivedZzimResponseDTO receivedZzimList = new StoreNotificationReceivedZzimResponseDTO();
    receivedZzimList.setZzimCustomers(receivedZzimCustomer);
    receivedZzimList.setZzimStores(receivedZzimStore);

    return receivedZzimList;
  }

  @RequestMapping(value = "/experience-list", method = RequestMethod.POST)
  public StoreNotificationExperienceListResponseDTO experienceList(@RequestBody StoreNotificationPageRequestDTO storeNotificationPageRequestDTO) {
      List<StoreNotificationExperienceApplyResponseDTO> expApply = storeNotificationPageService.storeNotificationExperienceApply(storeNotificationPageRequestDTO.getUserSeq());
      List<StoreNotificationExperienceProposeResponseDTO> expPropose = storeNotificationPageService.storeNotificationExperiencePropose(storeNotificationPageRequestDTO.getUserSeq());
      StoreNotificationExperienceListResponseDTO experienceList = new StoreNotificationExperienceListResponseDTO();
      experienceList.setApplyList(expApply);
      experienceList.setProposeList(expPropose);
      return experienceList;
  }

}
