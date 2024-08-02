package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerZzimedMeCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerZzimedMeStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeCustomersRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeStoresRetriveResponseDTO;

public interface CustomerMyNotificationService {

  CustomerZzimedMeCustomersRetrieveResponseDTO getZzimedMeCustomers(Long userSeq,
      CustomerZzimedMeCustomersRetrieveRequestDTO customerZzimedMeCustomersRetrieveRequestDTO);

  CustomerZzimedMeStoresRetriveResponseDTO getZzimedMeStores(Long userSeq,
      CustomerZzimedMeStoresRetrieveRequestDTO customerZzimedMeStoresRetrieveRequestDTO);

  void makeNotificationRead(Long userSeq, Long notificationSeq);

}
