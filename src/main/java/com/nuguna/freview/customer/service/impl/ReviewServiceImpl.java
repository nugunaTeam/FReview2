package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE;
import static com.nuguna.freview.customer.constant.CustomerConstant.CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE;

import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.dto.response.ReviewPaginationInfoResponseDTO;
import com.nuguna.freview.customer.exception.AlreadyExistReviewException;
import com.nuguna.freview.customer.exception.IllegalReviewException;
import com.nuguna.freview.customer.exception.IllegalReviewPageAccessException;
import com.nuguna.freview.customer.mapper.CustomerReviewMapper;
import com.nuguna.freview.customer.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

  private final CustomerReviewMapper customerReviewMapper;

  @Autowired
  public ReviewServiceImpl(CustomerReviewMapper customerReviewMapper) {
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

    if (customerReviewMapper.checkAlreadyExistReview(reviewSeq)) {
      throw new AlreadyExistReviewException("이미 등록완료 처리된 리뷰입니다.");
    }

    customerReviewMapper.registerReview(reviewSeq, reviewUrl);
    return new CustomerReviewRegisterResponseDTO(reviewUrl);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyReviewsRetrieveResponseDTO getCustomerMyReviews(
      CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO) {
    Long userSeq = customerMyReviewsRetrieveRequestDTO.getUserSeq();
    Integer currentPage = customerMyReviewsRetrieveRequestDTO.getPage();

    int offset = (currentPage - 1) * CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE;
    int reviewCount = customerReviewMapper.getReviewCount(userSeq);
    if (offset > reviewCount) {
      throw new IllegalReviewPageAccessException("해당하는 페이지에 대한 리뷰가 존재하지 않습니다.");
    }
    List<ReviewLogInfoDTO> reviewsInfo = customerReviewMapper.getReviewsInfo(userSeq, offset,
        CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE);

    int startPage =
        ((currentPage - 1) / CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE)
            * CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE
            + 1;
    int endPage;
    int pageBlockThreshold = startPage + CUSTOMER_REVIEW_LOG_PAGE_BLOCK_SIZE - 1;
    if (reviewCount >= pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE) {
      endPage = pageBlockThreshold;
    } else {
      endPage = (int) Math.ceil((double) reviewCount / CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE);
    }
    boolean hasNext = ((currentPage < endPage) || (reviewCount
        > pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE));
    boolean hasPrevious = (currentPage > 1);

    ReviewPaginationInfoResponseDTO reviewPaginationInfoResponseDTO = new ReviewPaginationInfoResponseDTO(
        currentPage, startPage, endPage, hasNext, hasPrevious);
    return new CustomerMyReviewsRetrieveResponseDTO(reviewsInfo, reviewPaginationInfoResponseDTO);
  }
}
