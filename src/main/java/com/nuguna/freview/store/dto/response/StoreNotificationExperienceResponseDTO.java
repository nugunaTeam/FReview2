package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationExperienceResponseDTO {
  private Long userSeq;
  private Long fromUserSeq;
  private Long toUserSeq;
  private Long postSeq;
  private String title;
  private String proposalDetail;
  private String experienceUser;
  private Timestamp createdAt;

}
