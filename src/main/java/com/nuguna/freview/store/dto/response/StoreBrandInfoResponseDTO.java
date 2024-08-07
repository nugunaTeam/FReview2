package com.nuguna.freview.store.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreBrandInfoResponseDTO {

  private String storeSeq;
  private String storeName;
  private Long zzimCount;
  private String introduce;
  private List<String> foodTypes;
  private List<String> tags;
  private String storeLocation;
}
