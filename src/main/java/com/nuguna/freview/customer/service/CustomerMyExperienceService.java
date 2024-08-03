package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyAcceptedApplyInfosRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyAcceptedProposalInfosRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerProposalToMeInfosRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAcceptedProposalInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyApplyInfosRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProposalToMeInfosRetrieveResponseDTO;

public interface CustomerMyExperienceService {

  CustomerMyApplyInfosRetrieveResponseDTO getMyApplyInfos(Long userSeq,
      int targetPage);

  CustomerProposalToMeInfosRetrieveResponseDTO getProposalToMeInfos(Long userSeq,
      CustomerProposalToMeInfosRetrieveRequestDTO customerProposalToMeInfosRetrieveRequestDTO);

  void acceptProposalToMe(Long userSeq, Long experienceSeq);

  void refuseProposalToMe(Long userSeq, Long experienceSeq);

  CustomerMyAcceptedApplyInfosRetrieveResponseDTO getMyAcceptedApplyInfos(Long userSeq,
      CustomerMyAcceptedApplyInfosRetrieveRequestDTO customerMyAcceptedApplyInfosRetrieveRequestDTO);

  CustomerMyAcceptedProposalInfosRetrieveResponseDTO getMyAcceptedProposalInfos(Long userSeq,
      CustomerMyAcceptedProposalInfosRetrieveRequestDTO customerMyAcceptedProposalInfosRetrieveRequestDTO);

}
