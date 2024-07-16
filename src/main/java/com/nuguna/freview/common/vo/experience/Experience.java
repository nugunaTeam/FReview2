package com.nuguna.freview.common.vo.experience;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

  private Long seq;
  private Long fromUserSeq;
  private Long toUserSeq;
  private Long fromPostSeq;
  private Boolean isCome;
  private String proposalDetail;
  private Date comfirmDate;
  private Date visitDate;
  private ExperienceStatusCode status;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public String getStatus() {
    return status != null ? status.getStatus() : null;
  }

  public void setStatus(String status) {
    this.status = ExperienceStatusCode.from(status);
  }
}