package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreBrandInfoResponseDTO;

public interface StoreBrandPageService {

  StoreBrandInfoResponseDTO getMyBrandPageInfo(Long storeSeq);
}
