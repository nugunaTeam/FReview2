package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.exception.IllegalReviewException;
import com.nuguna.freview.customer.mapper.CustomerReviewMapper;
import com.nuguna.freview.customer.service.CustomerReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerReviewServiceImpl implements CustomerReviewService {

  private final CustomerReviewMapper customerReviewMapper;

  @Autowired
  public CustomerReviewServiceImpl(CustomerReviewMapper customerReviewMapper) {
    this.customerReviewMapper = customerReviewMapper;
  }

  @Override
  public CustomerReviewRegisterResponseDTO registerCustomerReview(
      CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO) {
    Long userSeq = customerReviewRegisterRequestDTO.getUserSeq(); // Customer의 Seq
    Long reviewSeq = customerReviewRegisterRequestDTO.getReviewSeq();
    String reviewUrl = customerReviewRegisterRequestDTO.getReviewUrl();

    if (!customerReviewMapper.checkIsValidReview(userSeq, reviewSeq)) {
      throw new IllegalReviewException("존재하지 않는 리뷰입니다.");
    }
    customerReviewMapper.registerReview(reviewSeq, reviewUrl);
    return new CustomerReviewRegisterResponseDTO(reviewUrl);
  }

  @Override
  public List<ReviewLogInfoDTO> getReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO) {
    Long userSeq = customerMyReviewsRetrieveRequestDTO.getUserSeq();
    Integer currentPage = customerMyReviewsRetrieveRequestDTO.getCurrentPage();

    return customerReviewMapper.getReviewsInfo(userSeq,
        (currentPage - 1) * CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE, CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE);
  }
}
