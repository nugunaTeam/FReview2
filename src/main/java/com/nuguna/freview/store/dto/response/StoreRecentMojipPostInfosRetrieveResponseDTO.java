package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRecentMojipPostInfosRetrieveResponseDTO {

  private List<StoreRecentMojipPostInfoDTO> mojipPostInfos;
  private PaginationInfoResponseDTO paginationInfo;
}
