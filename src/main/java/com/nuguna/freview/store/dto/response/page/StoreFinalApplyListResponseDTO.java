package com.nuguna.freview.store.dto.response.page;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.store.dto.response.StoreFinalApplyListDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreFinalApplyListResponseDTO {
  private List<StoreFinalApplyListDTO> storeFinalApplyList;
  private PaginationInfoResponseDTO paginationInfo;
}
