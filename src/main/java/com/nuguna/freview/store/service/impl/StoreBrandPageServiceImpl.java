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
    // TODO : (스토어명, 찜 개수, 소개글, 활동분야 리스트, 태그 리스트, 위치)
    // TODO : 나머지 정보 ( 진행중인 모집글 정보 리스트, 받은 리뷰 리스트 => AJAX 처리 )
    return storeBrandPageMapper.getStoreBrandInfo(
        storeSeq);
  }
}
