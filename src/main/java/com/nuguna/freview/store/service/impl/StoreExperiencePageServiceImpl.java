package com.nuguna.freview.store.service.impl;

import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.response.StoreApplyListDTO;
import com.nuguna.freview.store.dto.response.StoreFinalApplyListDTO;
import com.nuguna.freview.store.dto.response.StoreFinalProposalListDTO;
import com.nuguna.freview.store.dto.response.StoreProposalListDTO;
import com.nuguna.freview.store.dto.response.StoreReviewListDTO;
import com.nuguna.freview.store.dto.response.page.StoreApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreReviewListResponseDTO;
import com.nuguna.freview.store.mapper.StoreExperiencePageMapper;
import com.nuguna.freview.store.service.StoreExperiencePageService;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Service
public class StoreExperiencePageServiceImpl implements StoreExperiencePageService {

  private final StoreExperiencePageMapper storeExperiencePageMapper;

  @Autowired
  public StoreExperiencePageServiceImpl(StoreExperiencePageMapper storeExperiencePageMapper) {
    this.storeExperiencePageMapper = storeExperiencePageMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public StoreApplyListResponseDTO applyList(@RequestParam Long userSeq, @RequestParam Integer currentPage, @RequestParam Integer pageSize){
      int applyListCount = storeExperiencePageMapper.getStoreApplyCount(userSeq);
      List<StoreApplyListDTO> applyListInfo = storeExperiencePageMapper.getStoreApplyList(
          userSeq, (currentPage -1)* STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
      );
      PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, applyListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
      );
      return new StoreApplyListResponseDTO(applyListInfo, paginationInfo);
  }

  @Override
  public void applyConfirm(Long experienceSeq, String status) {
    // 상태를 승인으로 업데이트함
    storeExperiencePageMapper.setStoreApplyStatus(experienceSeq);
  }


  @Override
  @Transactional(readOnly = true)
  public StoreProposalListResponseDTO proposalList(@RequestParam Long userSeq, @RequestParam Integer currentPage, @RequestParam Integer pageSize){
    int proposalListCount = storeExperiencePageMapper.getStoreProposalListCount(userSeq);
    List<StoreProposalListDTO> proposalListInfo = storeExperiencePageMapper.getStoreProposalList(
        userSeq, (currentPage -1)* STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, proposalListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    return new StoreProposalListResponseDTO(proposalListInfo, paginationInfo);
  }


  // 확정 - 지원
  @Override
  @Transactional
  public StoreFinalApplyListResponseDTO finalApplyList(@RequestParam Long userSeq, @RequestParam Integer currentPage, @RequestParam Integer pageSize){
    int finalApplyListCount = storeExperiencePageMapper.getStoreFinalApplyListCount(userSeq);
    List<StoreFinalApplyListDTO> storeFinalApplyListInfo = storeExperiencePageMapper.getStoreFinalApplyList(
        userSeq, (currentPage-1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, finalApplyListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    return new StoreFinalApplyListResponseDTO(storeFinalApplyListInfo, paginationInfo);
  }


  // 확정 - 제안
  @Override
  @Transactional
  public StoreFinalProposalListResponseDTO finalProposalList(@RequestParam Long userSeq, @RequestParam Integer currentPage, @RequestParam Integer pageSize){
    int finalProposalListCount = storeExperiencePageMapper.getStoreFinalProposalListCount(userSeq);
    List<StoreFinalProposalListDTO> storeFinalProposalListInfo = storeExperiencePageMapper.getStoreFinalProposalList(
        userSeq, (currentPage-1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, finalProposalListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    return new StoreFinalProposalListResponseDTO(storeFinalProposalListInfo, paginationInfo);
  }

  //
  public void updateExperienceDate(@RequestParam Long experienceSeq, @RequestParam LocalDate experienceDate){
    storeExperiencePageMapper.setUpdateExperienceDate(experienceSeq, experienceDate);
  };
  public void updateExperienceStatus(@RequestParam Long experienceSeq, @RequestParam String status){
    storeExperiencePageMapper.setUpdateExperienceStatus(experienceSeq, status);
  };



  // 리뷰 리스트
  @Override
  @Transactional
  public StoreReviewListResponseDTO storeReviewList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
    int reviewListCount = storeExperiencePageMapper.getStoreReviewListCount(userSeq);
    List<StoreReviewListDTO> storeReviewListInfo = storeExperiencePageMapper.getStoreReviewList(
        userSeq, (currentPage-1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        currentPage, reviewListCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    return new StoreReviewListResponseDTO(storeReviewListInfo, paginationInfo);
  }

  // 리뷰 숨김
  public void updateReviewStatus(@RequestParam Long seq, @RequestParam String status){
    storeExperiencePageMapper.setUpdateReviewStatus(seq, status);
  };

}
