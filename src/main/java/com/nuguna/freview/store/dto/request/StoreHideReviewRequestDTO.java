package com.nuguna.freview.store.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreHideReviewRequestDTO {

  @Min(1)
  private Long userSeq;
}
