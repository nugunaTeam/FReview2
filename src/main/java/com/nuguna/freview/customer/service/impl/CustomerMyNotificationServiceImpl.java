package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerMyNotificationPageConstant.CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyNotificationPageConstant.CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyNotificationPageConstant.CUSTOMER_ZZIMED_ME_STORES_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerMyNotificationPageConstant.CUSTOMER_ZZIMED_ME_STORES_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.CustomerZzimedMeCustomersRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerZzimedMeStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.ZzimedMeCustomerInfoDTO;
import com.nuguna.freview.customer.dto.response.ZzimedMeStoreInfoDTO;
import com.nuguna.freview.customer.mapper.CustomerMyNotificationMapper;
import com.nuguna.freview.customer.service.CustomerMyNotificationService;
import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerMyNotificationServiceImpl implements CustomerMyNotificationService {

  private final CustomerMyNotificationMapper customerMyNotificationMapper;

  @Autowired
  public CustomerMyNotificationServiceImpl(
      CustomerMyNotificationMapper customerMyNotificationMapper) {
    this.customerMyNotificationMapper = customerMyNotificationMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerZzimedMeCustomersRetrieveResponseDTO getZzimedMeCustomers(Long userSeq,
      Boolean isRead, Integer targetPage) {
    // TODO : isRead 를 통해 읽음, 안읽음 처리 구분 & targetPage에 해당하는 "나를 찜한 체험단" 정보 가져오기
    int zzimedMeCustomersCount = customerMyNotificationMapper.getZzimedMeCustomersCount(userSeq,
        isRead);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, zzimedMeCustomersCount,
        CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE, CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_BLOCK_SIZE);

    List<ZzimedMeCustomerInfoDTO> zzimedMeCustomers = customerMyNotificationMapper.getZzimedMeCustomers(
        userSeq, isRead,
        (targetPage - 1) * CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE,
        CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE);

    return new CustomerZzimedMeCustomersRetrieveResponseDTO(zzimedMeCustomers,
        paginationInfoResponseDTO);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerZzimedMeStoresRetrieveResponseDTO getZzimedMeStores(Long userSeq,
      Boolean isRead, Integer targetPage) {
    // TODO : isRead 를 통해 읽음, 안읽음 처리 구분 & targetPage에 해당하는 "나를 찜한 스토어" 정보 가져오기
    int zzimedMeStoresCount = customerMyNotificationMapper.getZzimedMeStoresCount(userSeq, isRead);

    PaginationInfoResponseDTO paginationInfoResponseDTO = PaginationUtil.makePaginationViewInfo(
        targetPage, zzimedMeStoresCount, CUSTOMER_ZZIMED_ME_STORES_PAGE_SIZE,
        CUSTOMER_ZZIMED_ME_STORES_PAGE_BLOCK_SIZE);

    List<ZzimedMeStoreInfoDTO> zzimedMeStores = customerMyNotificationMapper.getZzimedMeStores(
        userSeq, isRead,
        (targetPage - 1) * CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE,
        CUSTOMER_ZZIMED_ME_CUSTOMERS_PAGE_SIZE);

    return new CustomerZzimedMeStoresRetrieveResponseDTO(zzimedMeStores, paginationInfoResponseDTO);
  }

  @Override
  @Transactional
  public void makeNotificationRead(Long userSeq, Long notificationSeq) {
    // TODO : notificationSeq 에 해당하는 알림을 읽음 처리할 것
    if (!customerMyNotificationMapper.checkExistUnReadNotification(userSeq, notificationSeq)) {
      throw new IllegalArgumentException("해당하는 읽지 않은 알림이 존재하지 않습니다.");
    }
    customerMyNotificationMapper.makeNotificationRead(notificationSeq);
  }
}
