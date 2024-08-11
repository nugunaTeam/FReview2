package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerOtherReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerOtherReviewsRetrieveResponseDTO;

public interface CustomerReviewService {

  CustomerMyReviewRegisterResponseDTO registerCustomerReview(
      Long userSeq, CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO);

  CustomerMyReviewsRetrieveResponseDTO getCustomerMyReviews(
      Long userSeq, CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO);

  CustomerOtherReviewsRetrieveResponseDTO getOtherCustomerReviews(
      Long userSeq, CustomerOtherReviewsRetrieveRequestDTO customerOtherReviewsRetrieveRequestDTO);
}
