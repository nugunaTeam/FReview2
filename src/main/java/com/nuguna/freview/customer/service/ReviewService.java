package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;

public interface ReviewService {

  CustomerReviewRegisterResponseDTO registerCustomerReview(
      CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO);

  CustomerMyReviewsRetrieveResponseDTO getCustomerMyReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO);
}
