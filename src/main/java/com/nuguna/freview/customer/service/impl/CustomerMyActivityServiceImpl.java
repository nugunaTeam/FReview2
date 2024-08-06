package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_LIKE_POST_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_ZZIMED_CUSTOMERS_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_ZZIMED_CUSTOMERS_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_ZZIMED_STORES_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyActivityPageConstant.CUSTOMER_ZZIMED_STORES_PAGE_SIZE;

import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.MyLikePostInfoDTO;
import com.nuguna.freview.customer.dto.response.MyZzimedCustomerInfoDTO;
import com.nuguna.freview.customer.dto.response.MyZzimedStoreInfoDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.mapper.CustomerMyActivityMapper;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerMyActivityServiceImpl implements CustomerMyActivityService {

  private final CustomerMyActivityMapper customerMyActivityMapper;

  @Autowired
  public CustomerMyActivityServiceImpl(CustomerMyActivityMapper customerMyActivityMapper) {
    this.customerMyActivityMapper = customerMyActivityMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      int targetPage) {
    int likesCount = customerMyActivityMapper.getLikesCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, likesCount, CUSTOMER_LIKE_POST_PAGE_SIZE, CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE);

    List<MyLikePostInfoDTO> myLikedPostInfos = customerMyActivityMapper.getMyLikedPosts(userSeq,
        (targetPage - 1) * CUSTOMER_LIKE_POST_PAGE_SIZE,
        CUSTOMER_LIKE_POST_PAGE_SIZE);

    return new CustomerMyLikedPostsRetrieveResponseDTO(myLikedPostInfos, paginationInfoResponseDTO);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyZzimedStoresRetrieveResponseDTO getMyZzimedStores(Long userSeq,
      int targetPage) {
    int zzimedStoresCount = customerMyActivityMapper.getZzimedStoresCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, zzimedStoresCount, CUSTOMER_ZZIMED_STORES_PAGE_SIZE,
        CUSTOMER_ZZIMED_STORES_PAGE_BLOCK_SIZE);

    List<MyZzimedStoreInfoDTO> myZzimedStoreInfos = customerMyActivityMapper.getMyZzimedStores(
        userSeq,
        (targetPage - 1) * CUSTOMER_ZZIMED_STORES_PAGE_SIZE, CUSTOMER_ZZIMED_STORES_PAGE_SIZE);

    return new CustomerMyZzimedStoresRetrieveResponseDTO(myZzimedStoreInfos,
        paginationInfoResponseDTO);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyZzimedCustomersResponseDTO getMyZzimedCustomers(Long userSeq,
      CustomerMyZzimedCustomersRetrieveRequestDTO customerMyZzimedCustomersRetrieveRequestDTO) {
    Integer targetPage = customerMyZzimedCustomersRetrieveRequestDTO.getTargetPage();
    int zzimedCustomersCount = customerMyActivityMapper.getZzimedCustomersCount(userSeq);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, zzimedCustomersCount, CUSTOMER_ZZIMED_CUSTOMERS_PAGE_SIZE,
        CUSTOMER_ZZIMED_CUSTOMERS_PAGE_BLOCK_SIZE);

    List<MyZzimedCustomerInfoDTO> myZzimedCustomerInfos = customerMyActivityMapper.getMyZzimedCustomers(
        userSeq, (targetPage - 1) * CUSTOMER_ZZIMED_CUSTOMERS_PAGE_SIZE,
        CUSTOMER_ZZIMED_CUSTOMERS_PAGE_SIZE);

    return new CustomerMyZzimedCustomersResponseDTO(myZzimedCustomerInfos,
        paginationInfoResponseDTO);
  }


}
