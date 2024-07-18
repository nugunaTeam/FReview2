package com.nuguna.freview.admin.dto.response.page;

import com.nuguna.freview.admin.dto.response.StoreListDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreManageResponseDTO {

  private List<StoreListDTO> storeList;
  private boolean hasMore;
}
