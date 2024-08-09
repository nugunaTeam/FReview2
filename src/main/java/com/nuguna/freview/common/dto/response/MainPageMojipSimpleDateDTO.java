package com.nuguna.freview.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainPageMojipSimpleDateDTO {

  private Long postSeq;
  private String title;
  private String applyStartDate;
  private String applyEndDate;
  private String experienceDate;
  private String profilePhotoUrl;
  private String storeLocation;
  private String storeName;

}
