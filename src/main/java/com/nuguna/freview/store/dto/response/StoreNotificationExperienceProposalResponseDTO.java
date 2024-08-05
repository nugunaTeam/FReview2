package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationExperienceProposalResponseDTO {
  private List<ExperienceProposalInfoDTO> ExperienceProposalInfo;
  private PaginationUtil paginationInfo;

}
