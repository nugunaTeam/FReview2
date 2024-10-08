package com.nuguna.freview.customer.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyZzimedStoresRetrieveResponseDTO {

  private List<MyZzimedStoreInfoDTO> zzimedStoreInfos;

  private PaginationInfoResponseDTO paginationInfo;
}
