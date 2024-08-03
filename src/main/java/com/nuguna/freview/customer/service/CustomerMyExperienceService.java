package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedProposalInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProposalToMeInfosRetrieveResponseDTO;

public interface CustomerMyExperienceService {

  CustomerMyApplyInfosRetrieveResponseDTO getMyApplyInfos(Long userSeq,
      int targetPage);

  CustomerProposalToMeInfosRetrieveResponseDTO getProposalToMeInfos(Long userSeq,
      int targetPage);

  void acceptProposalToMe(Long userSeq, Long experienceSeq);

  void refuseProposalToMe(Long userSeq, Long experienceSeq);

  CustomerMyAcceptedApplyInfosRetrieveResponseDTO getMyAcceptedApplyInfos(Long userSeq,
      int targetPage);

  CustomerMyAcceptedProposalInfosRetrieveResponseDTO getMyAcceptedProposalInfos(Long userSeq,
      int targetPage);

}
