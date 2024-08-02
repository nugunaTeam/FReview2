package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;
import java.util.List;

public interface StoreActivityPageService {

//    StorePaginationIfoResponseDTO storePaginationInfo(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO);
    List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO);
    List<StoreActivitySendZzimStoreResponseDTO> storeActivitySendZzimStore(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO);
    List<StoreActivitySendZzimCustomerResponseDTO> storeActivitySendZzimCustomer(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO);
    List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO);
}
