package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.mapper.StoreActivityPageMapper;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class StoreActivityPageServiceImpl implements StoreActivityPageService {

  private final StoreActivityPageMapper storeActivityPageMapper;

  @Autowired
  public StoreActivityPageServiceImpl(StoreActivityPageMapper storeActivityPageMapper) {
    this.storeActivityPageMapper = storeActivityPageMapper;
  }

  @Override
  public List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq){
    return storeActivityPageMapper.storeActivityPageSendLike(userSeq);
  }

  @Override
  public List<StoreActivitySendZzimResponseDTO> storeActivityPageSendZzim(Long userSeq){
    return storeActivityPageMapper.storeActivityPageSendZzim(userSeq);
  }

  @Override
  public List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq){
    return storeActivityPageMapper.storeActivityPageWrittenPost(userSeq);
  }

}


