package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedReplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreNotificationPageResponseDTO;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
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
  public List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedLikeResponseDTO> receivedLike = storeNotificationPageService.storeNotificationReceivedLike(userSeq);
    return receivedLike;
  }

  @RequestMapping(value = "/received-zzim", method = RequestMethod.GET)
  public List<StoreNotificationReceivedZzimResponseDTO> storeNotificationReceivedZzim(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedZzimResponseDTO> receivedZzim = storeNotificationPageService.storeNotificationReceivedZzim(userSeq);
    return receivedZzim;
  }

  @RequestMapping(value = "/received-reply", method = RequestMethod.GET)
  public List<StoreNotificationReceivedReplyResponseDTO> receivedReply(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedReplyResponseDTO> receivedReply = storeNotificationPageService.storeNotificationReceivedReply(userSeq);
    return receivedReply;
  }

  @RequestMapping(value = "/experience-list", method = RequestMethod.GET)
  public List<StoreNotificationExperienceResponseDTO> experienceList(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationExperienceResponseDTO> experience = storeNotificationPageService.storeNotificationExperience(userSeq);
    return experience;
  }

  public StoreNotificationPageResponseDTO storeNotificationPage(@RequestParam("userSeq") Long userSeq) {
    List<StoreNotificationReceivedLikeResponseDTO> receivedLike = storeNotificationPageService.storeNotificationReceivedLike(userSeq);
    List<StoreNotificationReceivedZzimResponseDTO> receivedZzim = storeNotificationPageService.storeNotificationReceivedZzim(userSeq);
    List<StoreNotificationReceivedReplyResponseDTO> receivedReply = storeNotificationPageService.storeNotificationReceivedReply(userSeq);
    List<StoreNotificationExperienceResponseDTO> experience = storeNotificationPageService.storeNotificationExperience(userSeq);
    return new StoreNotificationPageResponseDTO(receivedLike, receivedZzim, receivedReply, experience);
  }

}
