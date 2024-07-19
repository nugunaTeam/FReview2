package com.nuguna.freview.common.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MojipPostDTO {

  private Long seq;
  private Long userSeq;
  private String businessNumber;
  private String profilePhotoUrl;
  private String storeLocation;
  private String foodTypeWord;
  private String tagWord;
  private String storeName;
  private String title;
  private Timestamp applyStartDate;
  private Timestamp applyEndDate;
  private Timestamp experienceDate;
  private String content;
  private int totalLike;
  private int totalView;
}
