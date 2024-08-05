package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.store.dto.response.StoreBrandInfoResponseDTO;
import com.nuguna.freview.store.mapper.StoreBrandPageMapper;
import com.nuguna.freview.store.service.StoreBrandPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class StoreBrandPageServiceImpl implements StoreBrandPageService {

  private final StoreBrandPageMapper storeBrandPageMapper;

  @Autowired
  public StoreBrandPageServiceImpl(StoreBrandPageMapper storeBrandPageMapper) {
    this.storeBrandPageMapper = storeBrandPageMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public StoreBrandInfoResponseDTO getMyBrandPageInfo(Long storeSeq) {
    return storeBrandPageMapper.getStoreBrandInfo(storeSeq);
  }
}
