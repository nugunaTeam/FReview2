package com.nuguna.freview.admin.dto.response.page;

import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManageResponseDTO {

  private List<CustomerListDTO> customerList;
  private boolean hasMore;
}
