package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import java.util.List;

public interface StoreActivityPageService {
    List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
    List<StoreActivitySendZzimStoreResponseDTO> storeActivitySendZzimStore(Long userSeq);
    List<StoreActivitySendZzimCustomerResponseDTO> storeActivitySendZzimCustomer(Long userSeq);
    List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq);
}
