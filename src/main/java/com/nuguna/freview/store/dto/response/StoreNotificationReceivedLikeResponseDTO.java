package com.nuguna.freview.store.dto.response;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationReceivedLikeResponseDTO {
  private List<ReceivedLikeInfoDTO> receivedLikeInfo;
  private PaginationInfoResponseDTO paginationInfo;
}
