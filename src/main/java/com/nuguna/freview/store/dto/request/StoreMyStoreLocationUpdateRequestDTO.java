package com.nuguna.freview.store.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreMyStoreLocationUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  @Length(max = 255)
  private String toStoreLocation;
}
