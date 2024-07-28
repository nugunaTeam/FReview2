package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import java.util.List;

public interface StoreNotificationPageService {
  List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(Long userSeq);
  List<StoreNotificationReceivedZzimCustomerResponseDTO> storeNotificationReceivedZzimCustomer(Long userSeq);
  List<StoreNotificationReceivedZzimStoreResponseDTO> storeNotificationReceivedZzimStore(Long userSeq);
  List<StoreNotificationExperienceApplyResponseDTO> storeNotificationExperienceApply(Long userSeq);
  List<StoreNotificationExperienceProposeResponseDTO> storeNotificationExperiencePropose(Long userSeq);
}
