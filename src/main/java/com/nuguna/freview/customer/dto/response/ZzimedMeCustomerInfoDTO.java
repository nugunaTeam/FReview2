package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimedMeCustomerInfoDTO {

  private Long notificationSeq;
  private Long customerSeq;
  private String nickname;
  private LocalDate createdAt;
}
