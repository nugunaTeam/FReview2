package com.nuguna.freview.store.dto.response.page;


import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationPageResponseDTO {
  private List<StoreNotificationReceivedLikeResponseDTO> receivedLike;
  private List<StoreNotificationReceivedZzimResponseDTO> receivedZzim;
  private List<StoreNotificationExperienceApplyResponseDTO> experienceApply;
  private List<StoreNotificationExperienceProposeResponseDTO> experiencePropose;

}
