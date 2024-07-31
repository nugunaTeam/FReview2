package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerLikePostConstant.CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerLikePostConstant.CUSTOMER_LIKE_POST_PAGE_SIZE;

import com.nuguna.freview.customer.dto.request.CustomerMyLikedPostsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.MyLikePostInfoDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.mapper.CustomerMyActivityMapper;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerMyActivityServiceImpl implements CustomerMyActivityService {

  private final CustomerMyActivityMapper customerMyActivityMapper;

  @Autowired
  public CustomerMyActivityServiceImpl(CustomerMyActivityMapper customerMyActivityMapper) {
    this.customerMyActivityMapper = customerMyActivityMapper;
  }

  @Override
  public CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      CustomerMyLikedPostsRetrieveRequestDTO customerMyLikedPostsRetrieveRequestDTO) {
    Integer targetPage = customerMyLikedPostsRetrieveRequestDTO.getTargetPage();
    int likesCount = customerMyActivityMapper.getLikesCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, likesCount, CUSTOMER_LIKE_POST_PAGE_SIZE, CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE);
    
    List<MyLikePostInfoDTO> myLikedPostInfos = customerMyActivityMapper.getMyLikedPosts(userSeq,
        (targetPage - 1) * CUSTOMER_LIKE_POST_PAGE_SIZE,
        CUSTOMER_LIKE_POST_PAGE_SIZE);

    return new CustomerMyLikedPostsRetrieveResponseDTO(myLikedPostInfos, paginationInfoResponseDTO);
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
