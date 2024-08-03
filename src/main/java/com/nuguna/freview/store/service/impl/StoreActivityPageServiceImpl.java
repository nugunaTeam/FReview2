package com.nuguna.freview.store.service.impl;

import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.response.SendZzimCustomerInfoDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreListPaginationResponseDTO;
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
  public List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO) {
    Integer targetPage = storeListPaginationResponseDTO.getTargetPage();
    if (targetPage == null || targetPage < 1) {
      targetPage = 1;
    }
    Integer likeListCount = storeActivityPageMapper.storeActivityPageSendLikeCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = null;
    try {
      paginationInfo = PaginationUtil.makePaginationViewInfo(
          targetPage, likeListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
      );
      return storeActivityPageMapper.storeActivityPageSendLike(userSeq, paginationInfo.getStartPage() - 1, paginationInfo.getEndPage() - paginationInfo.getStartPage() + 1);

    } catch (IllegalPageAccessException e) {
      log.error("like error : {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  // 찜한 체험단
  @Override
  public StoreActivitySendZzimCustomerResponseDTO storeActivitySendZzimCustomer(
                    Long userSeq, int targetPage) throws IllegalPageAccessException {

    int likeListCount = storeActivityPageMapper.storeActivitySendZzimCustomerCount(userSeq);
    log.info("likeListCount = {}", likeListCount);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
          targetPage, likeListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE);

    log.info("paginationInfoResponseDTO = {}", paginationInfo);

    List<SendZzimCustomerInfoDTO> sendZzimCustomerInfos = storeActivityPageMapper.storeActivitySendZzimCustomer(
        userSeq, (targetPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE);

    return new StoreActivitySendZzimCustomerResponseDTO(sendZzimCustomerInfos, paginationInfo);
  }

  // 찜한 스토어
  @Override
  public List<StoreActivitySendZzimStoreResponseDTO> storeActivitySendZzimStore(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO) {
    Integer targetPage = storeListPaginationResponseDTO.getTargetPage();
    if (targetPage == null || targetPage < 1) {
      targetPage = 1;
    }
    Integer likeListCount = storeActivityPageMapper.storeActivitySendZzimStoreCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = null;
    try {
      paginationInfo = PaginationUtil.makePaginationViewInfo(
          targetPage, likeListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
      );
      log.info("zzimStore paginationInfo : {}", paginationInfo);
      return storeActivityPageMapper.storeActivitySendZzimStore(userSeq, paginationInfo.getTargetPage(), STORE_LIST_PAGE_BLOCK_SIZE);

    } catch (IllegalPageAccessException e) {
      throw new RuntimeException(e);
    }


//    } catch (IllegalPageAccessException e) {
//      log.error("zzim store error : {}", e.getMessage());
//      throw new RuntimeException(e);
//    }
  }

  // 작성한 글
  @Override
  public List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq, StoreListPaginationResponseDTO storeListPaginationResponseDTO){
    Integer targetPage = storeListPaginationResponseDTO.getTargetPage();
    if (targetPage == null || targetPage < 1) {
      targetPage = 1;
    }
    Integer postListCount = storeActivityPageMapper.storeActivityPageWrittenPostCount(userSeq);
    PaginationInfoResponseDTO paginationInfo = null;
    try {
      paginationInfo = PaginationUtil.makePaginationViewInfo(
          targetPage, postListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
      );
      return storeActivityPageMapper.storeActivityPageWrittenPost(userSeq,(targetPage - 1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE);

    } catch (IllegalPageAccessException e) {
//      log.error("페이지 번호 오류: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

}


