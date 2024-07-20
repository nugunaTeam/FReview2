package com.nuguna.freview.common.dto.response.page;

import com.nuguna.freview.common.dto.response.RecommendationResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationListResponseDTO {

  private List<RecommendationResponseDTO> userList;
  private boolean hasMore;
}
