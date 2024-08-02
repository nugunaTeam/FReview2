package com.nuguna.freview.common.dto.response;

import com.nuguna.freview.common.dto.TopPerformersDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopPerformersResponseDTO {
  private List<TopPerformersDTO> topPerformers;
}
