package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import java.util.List;

public interface CustomerReviewService {

  CustomerReviewRegisterResponseDTO registerCustomerReview(
      CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO);

  List<ReviewLogInfoDTO> getReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO);
}
