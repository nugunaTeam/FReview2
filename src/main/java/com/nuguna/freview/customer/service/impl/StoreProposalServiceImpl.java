package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.store.dto.request.StoreProposalToCustomerRequestDTO;
import com.nuguna.freview.customer.exception.AlreadyExistProposalException;
import com.nuguna.freview.customer.exception.IllegalUserSeqException;
import com.nuguna.freview.store.mapper.StoreProposalMapper;
import com.nuguna.freview.customer.service.StoreProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreProposalServiceImpl implements StoreProposalService {

  private final StoreProposalMapper storeProposalMapper;

  @Autowired
  public StoreProposalServiceImpl(StoreProposalMapper storeProposalMapper) {
    this.storeProposalMapper = storeProposalMapper;
  }

  @Override
  @Transactional
  public void makeProposalToCustomer(
      Long storeSeq, StoreProposalToCustomerRequestDTO storeProposalToCustomerRequestDTO) {
    Long customerSeq = storeProposalToCustomerRequestDTO.getCustomerSeq();
    String proposalDetail = storeProposalToCustomerRequestDTO.getProposalDetail();

    String storeCode = storeProposalMapper.getUserCode(storeSeq);
    if (!UserCode.from(storeCode).isStore()) {
      throw new IllegalUserSeqException("제안하는 유저는 스토어 유저여야 합니다.");
    }

    String customerCode = storeProposalMapper.getUserCode(customerSeq);
    if (!UserCode.from(customerCode).isCustomer()) {
      throw new IllegalUserSeqException("제안받는 유저는 체험단 유저여야 합니다.");
    }

    if (storeProposalMapper.checkProposalExist(storeSeq, customerSeq)) {
      throw new AlreadyExistProposalException("이미 진행중인 제안이 있습니다.");
    }

    storeProposalMapper.makeProposalToCustomer(storeSeq, customerSeq, proposalDetail);
  }

}
