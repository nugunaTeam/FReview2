package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.CustomerAcceptedProposalToMeInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProposalToMeInfosRetrieveResponseDTO;

public interface CustomerMyExperienceService {

  CustomerMyApplyInfosRetrieveResponseDTO getMyApplyInfos(Long userSeq,
      int targetPage);

  CustomerProposalToMeInfosRetrieveResponseDTO getProposalToMeInfos(Long userSeq,
      int targetPage);

  void acceptProposalToMe(Long userSeq, Long experienceSeq);

  void rejectProposalToMe(Long userSeq, Long experienceSeq);

  CustomerMyAcceptedApplyInfosRetrieveResponseDTO getMyAcceptedApplyInfos(Long userSeq,
      int targetPage);

  CustomerAcceptedProposalToMeInfosRetrieveResponseDTO getMyAcceptedProposalInfos(Long userSeq,
      int targetPage);

}
