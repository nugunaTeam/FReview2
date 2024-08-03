package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_MY_APPLY_INFO_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_MY_APPLY_INFO_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_PROPOSAL_TO_ME_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyExperiencePageConstant.CUSTOMER_PROPOSAL_TO_ME_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedProposalInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProposalToMeInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.MyAcceptedApplyInfoDTO;
import com.nuguna.freview.customer.dto.response.MyApplyInfoDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.ProposalToMeInfoDTO;
import com.nuguna.freview.customer.mapper.CustomerMyExperienceMapper;
import com.nuguna.freview.customer.service.CustomerMyExperienceService;
import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CustomerMyExperienceServiceImpl implements CustomerMyExperienceService {

  private final CustomerMyExperienceMapper customerMyExperienceMapper;

  @Autowired
  public CustomerMyExperienceServiceImpl(CustomerMyExperienceMapper customerMyExperienceMapper) {
    this.customerMyExperienceMapper = customerMyExperienceMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyApplyInfosRetrieveResponseDTO getMyApplyInfos(Long userSeq,
      int targetPage) {

    int myApplyInfosCount = customerMyExperienceMapper.getMyApplyInfosCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, myApplyInfosCount,
        CUSTOMER_MY_APPLY_INFO_PAGE_SIZE, CUSTOMER_MY_APPLY_INFO_PAGE_BLOCK_SIZE);

    List<MyApplyInfoDTO> myApplyInfos = customerMyExperienceMapper.getMyApplyInfos(userSeq,
        (targetPage - 1) * CUSTOMER_MY_APPLY_INFO_PAGE_SIZE, CUSTOMER_MY_APPLY_INFO_PAGE_SIZE);

    return new CustomerMyApplyInfosRetrieveResponseDTO(myApplyInfos, paginationInfoResponseDTO);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerProposalToMeInfosRetrieveResponseDTO getProposalToMeInfos(Long userSeq,
      int targetPage) {

    int proposalToMeInfosCount = customerMyExperienceMapper.getProposalToMeInfosCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, proposalToMeInfosCount, CUSTOMER_PROPOSAL_TO_ME_PAGE_SIZE,
        CUSTOMER_PROPOSAL_TO_ME_PAGE_BLOCK_SIZE);

    List<ProposalToMeInfoDTO> proposalToMeInfos = customerMyExperienceMapper.getProposalToMeInfos(
        userSeq, (targetPage - 1) * CUSTOMER_PROPOSAL_TO_ME_PAGE_SIZE,
        CUSTOMER_PROPOSAL_TO_ME_PAGE_SIZE);

    return new CustomerProposalToMeInfosRetrieveResponseDTO(proposalToMeInfos,
        paginationInfoResponseDTO);
  }

  @Override
  public void acceptProposalToMe(Long userSeq, Long experienceSeq) {

  }

  @Override
  public void refuseProposalToMe(Long userSeq, Long experienceSeq) {

  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyAcceptedApplyInfosRetrieveResponseDTO getMyAcceptedApplyInfos(Long userSeq,
      int targetPage) {
    
    int myAcceptedApplyInfosCount = customerMyExperienceMapper.getMyAcceptedApplyInfosCount(
        userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, myAcceptedApplyInfosCount,
        CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_SIZE, CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_BLOCK_SIZE);

    List<MyAcceptedApplyInfoDTO> myAcceptedApplyInfos = customerMyExperienceMapper.getMyAcceptedApplyInfos(
        userSeq,
        (targetPage - 1) * CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_SIZE,
        CUSTOMER_MY_ACCEPTED_APPLY_INFO_PAGE_SIZE);

    return new CustomerMyAcceptedApplyInfosRetrieveResponseDTO(myAcceptedApplyInfos,
        paginationInfoResponseDTO);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyAcceptedProposalInfosRetrieveResponseDTO getMyAcceptedProposalInfos(
      Long userSeq, int targetPage) {
    return null;
  }
}
