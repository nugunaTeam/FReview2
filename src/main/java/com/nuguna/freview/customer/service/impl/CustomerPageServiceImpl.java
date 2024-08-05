package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE;
import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_OTHER_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_OTHER_BRAND_REVIEW_LOG_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerBrandInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerOtherBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.mapper.CustomerPageMapper;
import com.nuguna.freview.customer.mapper.CustomerReviewMapper;
import com.nuguna.freview.customer.service.CustomerPageService;
import com.nuguna.freview.global.util.PaginationUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CustomerPageServiceImpl implements CustomerPageService {

  private final CustomerPageMapper customerPageMapper;
  private final CustomerReviewMapper customerReviewMapper;

  @Autowired
  public CustomerPageServiceImpl(CustomerPageMapper customerPageMapper,
      CustomerReviewMapper customerReviewMapper) {
    this.customerPageMapper = customerPageMapper;
    this.customerReviewMapper = customerReviewMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public String getCustomerNickname(Long customerSeq) {
    return customerPageMapper.getNickname(customerSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq) {
    CustomerBrandInfoResponseDTO brandInfo = customerPageMapper.getBrandInfo(userSeq);

    int reviewsCount = customerReviewMapper.getReviewCount(userSeq);

    PaginationInfoResponseDTO reviewPaginationInfo = PaginationUtil.makePaginationViewInfo(1,
        reviewsCount,
        CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE,
        CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE);

    List<ReviewLogInfoDTO> reviewsInfo = customerReviewMapper.getReviewsInfo(userSeq, 0,
        CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE);

    return new CustomerMyBrandPageInfoResponseDTO(brandInfo, reviewsInfo, reviewPaginationInfo);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerOtherBrandPageInfoResponseDTO getOtherBrandPageInfo(Long userSeq) {
    CustomerBrandInfoResponseDTO otherBrandInfo = customerPageMapper.getBrandInfo(
        userSeq);

    int otherReviewsCount = customerReviewMapper.getOtherReviewCount(userSeq);

    PaginationInfoResponseDTO reviewPaginationInfo = PaginationUtil.makePaginationViewInfo(1,
        otherReviewsCount, CUSTOMER_OTHER_BRAND_REVIEW_LOG_PAGE_SIZE,
        CUSTOMER_OTHER_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE);

    List<ReviewLogInfoDTO> otherReviewsInfo = customerReviewMapper.getOtherReviewsInfo(userSeq, 0,
        CUSTOMER_OTHER_BRAND_REVIEW_LOG_PAGE_SIZE);

    return new CustomerOtherBrandPageInfoResponseDTO(otherBrandInfo, otherReviewsInfo,
        reviewPaginationInfo);
  }


}
