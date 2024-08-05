package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StoreNotificationReceivedZzimCustomerResponseDTO {
  private List<ReceivedZzimCustomerInfoDTO> ReceivedZzimCustomerInfo;
  private PaginationUtil paginationInfo;

}