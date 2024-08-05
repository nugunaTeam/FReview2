package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.response.StoreOtherReviewInfosRetrieveResponseDTO;
import com.nuguna.freview.store.dto.response.StoreOtherReviewLogInfoDTO;
import com.nuguna.freview.store.mapper.StoreOtherBrandMapper;
import com.nuguna.freview.store.service.StoreOtherBrandService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class StoreOtherBrandServiceImpl implements StoreOtherBrandService {

  private final StoreOtherBrandMapper storeOtherBrandMapper;

  @Autowired
  public StoreOtherBrandServiceImpl(StoreOtherBrandMapper storeOtherBrandMapper) {
    this.storeOtherBrandMapper = storeOtherBrandMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public StoreOtherReviewInfosRetrieveResponseDTO getOtherStoreReviewInfos(Long userSeq,
      int targetPage) {

    int otherStoreReviewsCount = storeOtherBrandMapper.getOtherStoreReviewsCount(userSeq);

    // TODO : 브랜치 머지 이후 매직 넘버를 상수로 바꿔줘야 함.
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(targetPage,
        otherStoreReviewsCount, 5, 5);

    List<StoreOtherReviewLogInfoDTO> storeOtherReviewLogInfos = storeOtherBrandMapper.getOtherStoreReviewInfos(
        userSeq, (targetPage - 1) * 5, 5);

    return new StoreOtherReviewInfosRetrieveResponseDTO(storeOtherReviewLogInfos, paginationInfo);
  }
}
