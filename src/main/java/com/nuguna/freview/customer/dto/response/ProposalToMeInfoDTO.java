package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalToMeInfoDTO {

  private Long experienceSeq;
  private Long storeSeq;
  private String storeName;
  private String proposalDetails;
  private String status;
  private LocalDate proposalDate;
}
