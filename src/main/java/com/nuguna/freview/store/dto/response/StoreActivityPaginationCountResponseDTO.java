package com.nuguna.freview.store.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivityPaginationCountResponseDTO {
  private List<StorePaginationInfoResponseDTO> paginationInfo;
  private StoreListPaginationResponseDTO storeListPaginationResponseDTO;
}
