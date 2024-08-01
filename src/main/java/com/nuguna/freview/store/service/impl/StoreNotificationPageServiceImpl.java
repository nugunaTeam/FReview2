package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import com.nuguna.freview.store.mapper.StoreNotificationPageMapper;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class StoreNotificationPageServiceImpl implements StoreNotificationPageService {
  private final StoreNotificationPageMapper storeNotificationPageMapper;

  @Autowired
  public StoreNotificationPageServiceImpl(StoreNotificationPageMapper storeNotificationPageMapper) {
    this.storeNotificationPageMapper = storeNotificationPageMapper;
  }

  @Override
  public List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(Long userSeq){
    return storeNotificationPageMapper.storeNotificationReceivedLike(userSeq);
  }

  @Override
  public List<StoreNotificationReceivedZzimCustomerResponseDTO> storeNotificationReceivedZzimCustomer(Long userSeq){
    return storeNotificationPageMapper.storeNotificationReceivedZzimCustomer(userSeq);
  }

  @Override
  public List<StoreNotificationReceivedZzimStoreResponseDTO> storeNotificationReceivedZzimStore(Long userSeq){
    return storeNotificationPageMapper.storeNotificationReceivedZzimStore(userSeq);
  }

  @Override
  public List<StoreNotificationExperienceApplyResponseDTO> storeNotificationExperienceApply(Long userSeq){
    return storeNotificationPageMapper.storeNotificationExperienceApply(userSeq);
  }

  @Override
  public List<StoreNotificationExperienceProposeResponseDTO> storeNotificationExperiencePropose(Long userSeq){
    return storeNotificationPageMapper.storeNotificationExperiencePropose(userSeq);
  }

}
