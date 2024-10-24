package com.nuguna.freview.store.dto.response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreListPaginationResponseDTO {
  @Min(1)
  @NotNull
  private Integer currentPage;
}
