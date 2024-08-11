package com.nuguna.freview.customer.service;

import com.nuguna.freview.store.dto.request.StoreProposalToCustomerRequestDTO;

public interface StoreProposalService {

  void makeProposalToCustomer(Long storeSeq, StoreProposalToCustomerRequestDTO storeProposalToCustomerRequestDTO);

}
