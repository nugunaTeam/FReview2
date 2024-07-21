package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimResponseDTO;
import java.util.List;

public interface StoreActivityPageService {
    List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
    List<StoreActivitySendZzimResponseDTO> storeActivityPageSendZzim(Long userSeq);

}
