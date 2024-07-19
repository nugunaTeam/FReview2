package com.nuguna.freview.admin.dto.response.page;

import com.nuguna.freview.admin.dto.response.CustomerInfoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManageResponseDTO {

  private List<CustomerInfoDTO> customerList;
  private boolean hasMore;
}
