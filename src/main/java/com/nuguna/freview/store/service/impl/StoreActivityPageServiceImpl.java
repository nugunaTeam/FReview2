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
  public StoreListPaginationResponseDTO storePaginationInfo(Long userSeq, int targetPage) {
    return null;
  }

  @Override
  public StoreActivitySendLikeResponseDTO storeActivityPageSendLike(
      Long userSeq, int targetPage) throws IllegalPageAccessException {

    int likeListCount = storeActivityPageMapper.storeActivityPageSendLikeCount(userSeq);
    log.info("likeListCount :: ", likeListCount);
    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
      targetPage, likeListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    log.info(" like -- paginationInfos :: ", paginationInfos);
    List<SendLikeInfoDTO> sendLikeInfos = storeActivityPageMapper.storeActivityPageSendLike(
        userSeq, (targetPage - 1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    log.info("sendLikeInfos :: ", sendLikeInfos);
    return  new StoreActivitySendLikeResponseDTO(sendLikeInfos, paginationInfos);
  }

  // 찜한 체험단
  @Override
  public StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimCustomer(
                    Long userSeq, int targetPage) throws IllegalPageAccessException {

    int zzimCustomerCount = storeActivityPageMapper.storeActivitySendZzimCustomerCount(userSeq);
    log.info("likeListCount = {}", zzimCustomerCount);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
          targetPage, zzimCustomerCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE);

    log.info("paginationInfoResponseDTO = {}", paginationInfo);

    List<SendZzimCustomerInfoDTO> sendZzimCustomerInfos = storeActivityPageMapper.storeActivitySendZzimCustomer(
        userSeq, (targetPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE);

    return new StoreActivitySendZzimCustomerResponseDTO(sendZzimCustomerInfos, paginationInfo);
  }

  // 찜한 스토어
  @Override
  public StoreActivitySendZzimStoreResponseDTO storeActivitySendZzimStore(Long userSeq,
                                                  int targetPage) throws IllegalPageAccessException {
    int zzimStoreCount = storeActivityPageMapper.storeActivitySendZzimStoreCount(userSeq);
    log.info("zzimStoreCount : ", zzimStoreCount);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        targetPage, zzimStoreCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    log.info("paginationInfos : ", paginationInfo);
    List<SendZzimStoreInfoDTO> sendZzimStoreInfos = storeActivityPageMapper.storeActivitySendZzimStore(
        userSeq, (targetPage-1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    log.info("sendZzimStoreInfos", sendZzimStoreInfos);
    return new StoreActivitySendZzimStoreResponseDTO(sendZzimStoreInfos, paginationInfo);
  }

  // 작성한 글
  @Override
  public StoreActivityWrittenPostResponseDTO storeActivityPageWrittenPost(Long userSeq,
                                                int targetPage) throws IllegalPageAccessException {

    int postListCount = storeActivityPageMapper.storeActivityPageWrittenPostCount(userSeq);
    log.info("postListCount = {}", postListCount);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        targetPage, postListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    log.info("paginationInfoResponseDTO ::: ", paginationInfo);
    List<WrittenPostInfoDTO> writtenPostInfos = storeActivityPageMapper.storeActivityPageWrittenPost(
        userSeq, (targetPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    log.info("writtenPostInfos ::: ", writtenPostInfos);
    return new StoreActivityWrittenPostResponseDTO(writtenPostInfos, paginationInfo);
  }

}


