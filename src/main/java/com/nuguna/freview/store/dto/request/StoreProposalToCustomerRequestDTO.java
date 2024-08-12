package com.nuguna.freview.store.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProposalToCustomerRequestDTO {

  @Min(1)
  private Long customerSeq;

  @Length(max = 100)
  private String proposalDetail;

}
