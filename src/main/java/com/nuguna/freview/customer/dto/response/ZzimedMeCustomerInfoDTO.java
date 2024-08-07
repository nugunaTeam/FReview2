package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimedMeCustomerInfoDTO {

  // EX MESSAGE : "${nickname}" 님이 나를 찜하였습니다.
  private Long notificationSeq;
  private Long customerSeq;
  private String nickname;
  private LocalDate createdAt;
}
