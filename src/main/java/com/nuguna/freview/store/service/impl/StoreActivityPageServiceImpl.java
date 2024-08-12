package com.nuguna.freview.store.service.impl;

import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.response.SendLikeInfoDTO;
import com.nuguna.freview.store.dto.response.SendZzimCustomerInfoDTO;
import com.nuguna.freview.store.dto.response.SendZzimStoreInfoDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;
import com.nuguna.freview.store.dto.response.WrittenPostInfoDTO;
import com.nuguna.freview.store.mapper.StoreActivityPageMapper;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class StoreActivityPageServiceImpl implements StoreActivityPageService {

  private final StoreActivityPageMapper storeActivityPageMapper;

  @Autowired
  public StoreActivityPageServiceImpl(StoreActivityPageMapper storeActivityPageMapper) {
    this.storeActivityPageMapper = storeActivityPageMapper;
  }

  @Override
  public StoreListPaginationResponseDTO storePaginationInfo(Long userSeq, int currentPage) {
    return null;
  }

  @Override
  public StoreActivitySendLikeResponseDTO storeActivityPageSendLike(
                                              Long userSeq, int currentPage) throws IllegalPageAccessException {
    int likeListCount = storeActivityPageMapper.storeActivityPageSendLikeCount(userSeq);
    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
        currentPage, likeListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<SendLikeInfoDTO> sendLikeInfos = storeActivityPageMapper.storeActivityPageSendLike(
        userSeq, (currentPage - 1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    return  new StoreActivitySendLikeResponseDTO(sendLikeInfos, paginationInfos);
  }

  // 찜한 체험단
  @Override
  public StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimCustomer(
                    Long userSeq, int currentPage) throws IllegalPageAccessException {
    int zzimCustomerCount = storeActivityPageMapper.storeActivitySendZzimCustomerCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, zzimCustomerCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<SendZzimCustomerInfoDTO> sendZzimCustomerInfos = storeActivityPageMapper.storeActivitySendZzimCustomer(
        userSeq, (currentPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreActivitySendZzimCustomerResponseDTO(sendZzimCustomerInfos, paginationInfo);
  }

  // 찜한 스토어
  @Override
  public StoreActivitySendZzimStoreResponseDTO storeActivitySendZzimStore(Long userSeq,
                                                  int currentPage) throws IllegalPageAccessException {
    int zzimStoreCount = storeActivityPageMapper.storeActivitySendZzimStoreCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, zzimStoreCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<SendZzimStoreInfoDTO> sendZzimStoreInfos = storeActivityPageMapper.storeActivitySendZzimStore(
        userSeq, (currentPage-1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreActivitySendZzimStoreResponseDTO(sendZzimStoreInfos, paginationInfo);
  }

  // 작성한 글
  @Override
  public StoreActivityWrittenPostResponseDTO storeActivityPageWrittenPost(Long userSeq,
                                                int currentPage) throws IllegalPageAccessException {

    int postListCount = storeActivityPageMapper.storeActivityPageWrittenPostCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, postListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<WrittenPostInfoDTO> writtenPostInfos = storeActivityPageMapper.storeActivityPageWrittenPost(
        userSeq, (currentPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreActivityWrittenPostResponseDTO(writtenPostInfos, paginationInfo);
  }

}


