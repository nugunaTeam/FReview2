package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import java.util.List;

public interface StoreNotificationPageService {
  List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(Long userSeq);
  List<StoreNotificationReceivedZzimResponseDTO> storeNotificationReceivedZzim(Long userSeq);
  List<StoreNotificationExperienceResponseDTO> storeNotificationExperience(Long userSeq);
}
