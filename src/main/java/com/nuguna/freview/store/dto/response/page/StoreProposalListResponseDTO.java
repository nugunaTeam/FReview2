package com.nuguna.freview.store.dto.response.page;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.store.dto.response.StoreProposalListDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProposalListResponseDTO {
  private List<StoreProposalListDTO> proposalList;
  private PaginationInfoResponseDTO paginationInfo;
}
