package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.common.vo.user.foodType.FoodType;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivitySendZzimResponseDTO {
  private Long userSeq;
  private Long toUserSeq;
  private String nickname;
  private String code;
  private String storeLocation;
  private Long zzimCount;
  private List<FoodType> foodTypeList;
  private Timestamp createdAt;

}
