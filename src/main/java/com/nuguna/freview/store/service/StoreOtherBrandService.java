package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreOtherReviewInfosRetrieveResponseDTO;

public interface StoreOtherBrandService {

  StoreOtherReviewInfosRetrieveResponseDTO getOtherStoreReviewInfos(Long userSeq,
      int targetPage);
}
