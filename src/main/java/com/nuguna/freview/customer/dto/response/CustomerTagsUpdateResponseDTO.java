package com.nuguna.freview.customer.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTagsUpdateResponseDTO {

  private List<String> foodTypes;
}
