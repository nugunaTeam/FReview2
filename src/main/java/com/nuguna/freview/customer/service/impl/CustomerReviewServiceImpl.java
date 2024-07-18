package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.exception.IllegalReviewException;
import com.nuguna.freview.customer.mapper.CustomerReviewMapper;
import com.nuguna.freview.customer.service.CustomerReviewService;
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
}
