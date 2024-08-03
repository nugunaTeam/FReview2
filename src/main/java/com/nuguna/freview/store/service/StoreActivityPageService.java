package com.nuguna.freview.store.service;

import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;

public interface StoreActivityPageService {

    StoreListPaginationResponseDTO storePaginationInfo(Long userSeq, int targetPage);
    StoreActivitySendLikeResponseDTO storeActivityPageSendLike(Long userSeq, int targetPage)
        throws IllegalPageAccessException;
    StoreActivitySendZzimStoreResponseDTO storeActivitySendZzimStore(Long userSeq, int targetPAge)
        throws IllegalPageAccessException;
    StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimCustomer(Long userSeq, int targetPage)
        throws IllegalPageAccessException;
    StoreActivityWrittenPostResponseDTO storeActivityPageWrittenPost(Long userSeq, int targetPage)
        throws IllegalPageAccessException;
}
