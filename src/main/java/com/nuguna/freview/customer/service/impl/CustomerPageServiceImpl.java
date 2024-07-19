package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE;
import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_REVIEW_LOG_FIRST_PAGE_NUMBER;
import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE;

import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.dto.response.ReviewPaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerBrandInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.mapper.CustomerPageMapper;
import com.nuguna.freview.customer.mapper.CustomerReviewMapper;
import com.nuguna.freview.customer.service.CustomerPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
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
  public CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq) {
    CustomerBrandInfoResponseDTO brandInfo = customerPageMapper.getBrandInfo(userSeq);
    List<ReviewLogInfoDTO> reviewsInfo = customerReviewMapper.getReviewsInfo(userSeq, 0,
        CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE);
    int reviewCount = customerReviewMapper.getReviewCount(userSeq);

    int endPage = (reviewCount / 5) + 1;
    if (reviewCount > CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE
        * (CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE - 1)) {
      endPage = CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE;
    }

    ReviewPaginationInfoResponseDTO reviewPaginationInfo
        = new ReviewPaginationInfoResponseDTO(CUSTOMER_REVIEW_LOG_FIRST_PAGE_NUMBER,
        CUSTOMER_REVIEW_LOG_FIRST_PAGE_NUMBER, endPage);
    return new CustomerMyBrandPageInfoResponseDTO(brandInfo, reviewsInfo, reviewPaginationInfo);
  }


}
