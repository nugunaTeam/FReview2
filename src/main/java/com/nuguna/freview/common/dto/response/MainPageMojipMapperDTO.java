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
public class MainPageMojipMapperDTO {
  private Long postSeq;
  private String title;
  private Timestamp applyStartDate;
  private Timestamp applyEndDate;
  private Timestamp experienceDate;
  private String profilePhotoUrl;
  private String storeLocation;
  private String storeName;
}
