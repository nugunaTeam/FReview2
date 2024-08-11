package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.customer.dto.request.ProposalToCustomerRequestDTO;
import com.nuguna.freview.customer.exception.AlreadyExistProposalException;
import com.nuguna.freview.customer.exception.IllegalUserSeqException;
import com.nuguna.freview.customer.mapper.CustomerProposalMapper;
import com.nuguna.freview.customer.service.CustomerProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerProposalServiceImpl implements CustomerProposalService {

  private final CustomerProposalMapper customerProposalMapper;

  @Autowired
  public CustomerProposalServiceImpl(CustomerProposalMapper customerProposalMapper) {
    this.customerProposalMapper = customerProposalMapper;
  }

  @Override
  @Transactional
  public void makeProposalToCustomer(
      ProposalToCustomerRequestDTO proposalToCustomerRequestDTO) {
    Long storeSeq = proposalToCustomerRequestDTO.getStoreSeq();
    Long customerSeq = proposalToCustomerRequestDTO.getCustomerSeq();
    String proposalDetail = proposalToCustomerRequestDTO.getProposalDetail();

    String storeCode = customerProposalMapper.getUserCode(storeSeq);
    if (!UserCode.from(storeCode).isStore()) {
      throw new IllegalUserSeqException("제안하는 유저는 스토어 유저여야 합니다.");
    }

    String customerCode = customerProposalMapper.getUserCode(customerSeq);
    if (!UserCode.from(customerCode).isCustomer()) {
      throw new IllegalUserSeqException("제안받는 유저는 체험단 유저여야 합니다.");
    }

    if (customerProposalMapper.checkProposalExist(storeSeq, customerSeq)) {
      throw new AlreadyExistProposalException("이미 진행중인 제안이 있습니다.");
    }

    customerProposalMapper.makeProposalToCustomer(storeSeq, customerSeq, proposalDetail);
  }

}
