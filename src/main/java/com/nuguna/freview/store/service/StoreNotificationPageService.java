package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposalResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;

public interface StoreNotificationPageService {
  StoreNotificationReceivedLikeResponseDTO storeNotificationReceivedLike(Long userSeq, int currentPage);
  StoreNotificationReceivedZzimCustomerResponseDTO storeNotificationReceivedZzimCustomer(Long userSeq, int currentPage);
  StoreNotificationReceivedZzimStoreResponseDTO storeNotificationReceivedZzimStore(Long userSeq, int currentPage);
  StoreNotificationExperienceApplyResponseDTO storeNotificationExperienceApply(Long userSeq, int currentPage);
  StoreNotificationExperienceProposalResponseDTO storeNotificationExperienceProposal(Long userSeq, int currentPage);
}
