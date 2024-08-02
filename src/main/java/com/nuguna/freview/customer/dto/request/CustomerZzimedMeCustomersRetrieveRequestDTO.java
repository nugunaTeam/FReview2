package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerZzimedMeCustomersRetrieveRequestDTO {

  @NotNull
  private Boolean isRead;

  @Min(1)
  @NotNull
  private Integer targetPage;

}
