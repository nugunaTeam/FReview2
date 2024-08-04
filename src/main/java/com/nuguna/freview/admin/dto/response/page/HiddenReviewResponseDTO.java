package com.nuguna.freview.admin.dto.response.page;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HiddenReviewResponseDTO {

  private List<HiddenReviewDTO> reviewList;
  private int pageTotalCount;
}
