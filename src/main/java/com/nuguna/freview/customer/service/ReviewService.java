package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;

public interface ReviewService {

  CustomerMyReviewRegisterResponseDTO registerCustomerReview(
      CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO);

  CustomerMyReviewsRetrieveResponseDTO getCustomerMyReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO);
}
