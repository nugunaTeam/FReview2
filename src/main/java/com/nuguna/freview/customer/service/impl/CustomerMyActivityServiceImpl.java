package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.dto.request.CustomerMyLikedPostsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerMyActivityServiceImpl implements CustomerMyActivityService {

  @Override
  public CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      CustomerMyLikedPostsRetrieveRequestDTO customerMyLikedPostsRetrieveRequestDTO) {
    return null;
  }

  @Override
  public CustomerMyZzimedStoresRetrieveResponseDTO getMyZzimedStores(Long userSeq,
      CustomerMyZzimedStoresRetrieveRequestDTO customerMyZzimedStoresRetrieveRequestDTO) {
    return null;
  }

  @Override
  public CustomerMyZzimedCustomersResponseDTO getMyZzimedCustomers(Long userSeq,
      CustomerMyZzimedCustomersRetrieveRequestDTO customerMyZzimedCustomersRetrieveRequestDTO) {
    return null;
  }


}
