package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;

public interface CustomerMyActivityService {

  CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      int targetPage);

  CustomerMyZzimedStoresRetrieveResponseDTO getMyZzimedStores(Long userSeq,
      int targetPage);

  CustomerMyZzimedCustomersResponseDTO getMyZzimedCustomers(Long userSeq,
      int targetPage);

}
