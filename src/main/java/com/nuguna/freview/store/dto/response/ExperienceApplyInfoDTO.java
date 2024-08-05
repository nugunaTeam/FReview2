package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceApplyInfoDTO {
  private Long userSeq;
  private Long fromUserSeq;
  private Long postSeq;
  private String title;
  private String nickname;
  private String status;
  private Timestamp createdAt;
}
