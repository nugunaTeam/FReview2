package com.nuguna.freview.store.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationExperienceListResponseDTO {
  private List<StoreNotificationExperienceApplyResponseDTO> applyList;
  private List<StoreNotificationExperienceProposeResponseDTO> proposeList;
}
