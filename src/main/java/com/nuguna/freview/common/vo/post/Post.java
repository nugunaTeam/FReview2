package com.nuguna.freview.common.vo.post;

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
public class Post {

  private Long seq;
  private Long userSeq;
  private PostCode code;
  private String title;
  private Date applyStartDate;
  private Date applyEndDate;
  private Date experienceDate;
  private String content;
  private Integer totalView;
  private String thumbnailPhotoUrl;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public String getCode() {
    return code != null ? code.getCode() : null;
  }

  public void setCode(String gubun) {
    this.code = PostCode.from(gubun);
  }
}