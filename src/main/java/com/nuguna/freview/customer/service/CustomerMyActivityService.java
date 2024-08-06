package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;

public interface CustomerMyActivityService {

  CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      int targetPage);

  CustomerMyZzimedStoresRetrieveResponseDTO getMyZzimedStores(Long userSeq,
      CustomerMyZzimedStoresRetrieveRequestDTO customerMyZzimedStoresRetrieveRequestDTO);

  CustomerMyZzimedCustomersResponseDTO getMyZzimedCustomers(Long userSeq,
      CustomerMyZzimedCustomersRetrieveRequestDTO customerMyZzimedCustomersRetrieveRequestDTO);

}
