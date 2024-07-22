package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import java.util.List;

public interface CustomerReviewService {

  CustomerMyReviewRegisterResponseDTO registerCustomerReview(
      CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO);

  List<ReviewLogInfoDTO> getReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO);
}
