package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationExperienceApplyResponseDTO {
  private List<ExperienceApplyInfoDTO> ExperienceApplyInfo;
  private PaginationUtil paginationInfo;
}
