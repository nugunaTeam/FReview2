package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.CustomerZzimedMeCustomersRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeStoresRetrieveResponseDTO;

public interface CustomerMyNotificationService {

  CustomerZzimedMeCustomersRetrieveResponseDTO getZzimedMeCustomers(Long userSeq, Boolean isRead,
      Integer targetPage);

  CustomerZzimedMeStoresRetrieveResponseDTO getZzimedMeStores(Long userSeq,
      Boolean isRead, Integer targetPage);

  void makeNotificationRead(Long userSeq, Long notificationSeq);

}
