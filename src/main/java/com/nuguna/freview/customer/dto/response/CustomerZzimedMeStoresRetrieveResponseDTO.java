package com.nuguna.freview.customer.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerZzimedMeStoresRetrieveResponseDTO {

  // EX MESSAGE : "${storeName}" 님이 나를 찜하였습니다.
  private List<ZzimedMeStoreInfoDTO> zzimedMeStoreInfos;
  private PaginationInfoResponseDTO paginationInfo;
}
