package com.nuguna.freview.store.service;

import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;

public interface StoreActivityPageService {

    StoreListPaginationResponseDTO storePaginationInfo(Long userSeq, int currentPage);
    StoreActivitySendLikeResponseDTO storeActivityPageSendLike(Long userSeq, int currentPage)
        throws IllegalPageAccessException;
    StoreActivitySendZzimStoreResponseDTO storeActivitySendZzimStore(Long userSeq, int currentPage)
        throws IllegalPageAccessException;
    StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimCustomer(Long userSeq, int currentPage)
        throws IllegalPageAccessException;
    StoreActivityWrittenPostResponseDTO storeActivityPageWrittenPost(Long userSeq, int currentPage)
        throws IllegalPageAccessException;
}
