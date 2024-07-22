package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import java.util.List;

public interface StoreActivityPageService {
    List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
    List<StoreActivitySendZzimResponseDTO> storeActivityPageSendZzim(Long userSeq);
    List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq);
}
