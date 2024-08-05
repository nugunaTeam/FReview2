package com.nuguna.freview.store.service.impl;

import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreListConstant.STORE_LIST_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.response.ExperienceApplyInfoDTO;
import com.nuguna.freview.store.dto.response.ExperienceProposalInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedLikeInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedZzimCustomerInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedZzimStoreInfoDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposalResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import com.nuguna.freview.store.mapper.StoreNotificationPageMapper;
import com.nuguna.freview.store.service.StoreNotificationPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class StoreNotificationPageServiceImpl implements StoreNotificationPageService {

  private final StoreNotificationPageMapper storeNotificationPageMapper;

  @Autowired
  public StoreNotificationPageServiceImpl(StoreNotificationPageMapper storeNotificationPageMapper) {
    this.storeNotificationPageMapper = storeNotificationPageMapper;
  }

  @Override
  public StoreNotificationReceivedLikeResponseDTO storeNotificationReceivedLike(Long userSeq,
      int currentPage) {
      Integer receivedLikeCount = storeNotificationPageMapper.storeNotificationPageReceivedLikeCount(
          userSeq);
    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
      currentPage, receivedLikeCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );

    List<ReceivedLikeInfoDTO> receivedLikeInfo = storeNotificationPageMapper.storeNotificationReceivedLike(
        userSeq, (currentPage -1) * STORE_LIST_PAGE_SIZE , STORE_LIST_PAGE_SIZE
    );

    return new StoreNotificationReceivedLikeResponseDTO(receivedLikeInfo, paginationInfo);
  }

  @Override
  public StoreNotificationReceivedZzimCustomerResponseDTO storeNotificationReceivedZzimCustomer(
      Long userSeq, int currentPage) {
    int receivedZzimCustomerCount = storeNotificationPageMapper.storeNotificationPageReceivedZzimCustomerCount(userSeq);

    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
        currentPage, receivedZzimCustomerCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<ReceivedZzimCustomerInfoDTO> receivedZzimCustomerInfo = storeNotificationPageMapper.storeNotificationReceivedZzimCustomer(
        userSeq, (currentPage -1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreNotificationReceivedZzimCustomerResponseDTO(receivedZzimCustomerInfo, paginationInfos);
  }

  @Override
  public StoreNotificationReceivedZzimStoreResponseDTO storeNotificationReceivedZzimStore(Long userSeq,
      int currentPage) {
    int receivedZzimStoreCount = storeNotificationPageMapper.storeNotificationPageReceivedZzimStoreCount(userSeq);
    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
        currentPage, receivedZzimStoreCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<ReceivedZzimStoreInfoDTO> receivedZzimStoreInfo = storeNotificationPageMapper.storeNotificationReceivedZzimStore(
        userSeq, (currentPage -1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreNotificationReceivedZzimStoreResponseDTO(receivedZzimStoreInfo, paginationInfos);
  }

  @Override
  public StoreNotificationExperienceApplyResponseDTO storeNotificationExperienceApply(Long userSeq,
      int currentPage) {
    int experienceApplyCount = storeNotificationPageMapper.storeNotificationPageActivityApplyCount(userSeq);
    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
        currentPage, experienceApplyCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<ExperienceApplyInfoDTO> experienceApplyInfo =  storeNotificationPageMapper.storeNotificationExperienceApply(
        userSeq, (currentPage -1) * STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreNotificationExperienceApplyResponseDTO(experienceApplyInfo, paginationInfos);
  }

  @Override
  public StoreNotificationExperienceProposalResponseDTO storeNotificationExperienceProposal(Long userSeq,
      int currentPage) {
    int experienceProposalCount = storeNotificationPageMapper.storeNotificationPageActivityProposalCount(userSeq);
    PaginationInfoResponseDTO paginationInfos = PaginationUtil.makePaginationViewInfo(
      currentPage, experienceProposalCount, STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_BLOCK_SIZE
    );
    List<ExperienceProposalInfoDTO> experienceProposalInfo = storeNotificationPageMapper.storeNotificationExperienceProposal(
        userSeq, (currentPage -1)*STORE_LIST_PAGE_SIZE, STORE_LIST_PAGE_SIZE
    );
    return new StoreNotificationExperienceProposalResponseDTO( experienceProposalInfo, paginationInfos);
  }

}
