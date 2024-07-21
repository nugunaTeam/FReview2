package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedReplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import com.nuguna.freview.store.mapper.StoreNotificationPageMapper;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
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
  public List<StoreNotificationReceivedZzimResponseDTO> storeNotificationReceivedZzim(Long userSeq){
    return storeNotificationPageMapper.storeNotificationReceivedZzim(userSeq);
  }

  @Override
  public List<StoreNotificationReceivedReplyResponseDTO> storeNotificationReceivedReply(Long userSeq){
    return storeNotificationPageMapper.storeNotificationReceivedReply(userSeq);
  }

  @Override
  public List<StoreNotificationExperienceResponseDTO> storeNotificationExperience(Long userSeq){
    return storeNotificationPageMapper.storeNotificationExperience(userSeq);
  }


}
