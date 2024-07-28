package com.nuguna.freview.store.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationReceivedZzimResponseDTO {
  List<StoreNotificationReceivedZzimCustomerResponseDTO>  zzimCustomers;
  List<StoreNotificationReceivedZzimStoreResponseDTO>  zzimStores;
}
