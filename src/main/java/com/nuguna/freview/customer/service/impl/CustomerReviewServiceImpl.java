package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE;

import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerOtherReviewsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerOtherReviewsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import com.nuguna.freview.customer.exception.AlreadyExistReviewException;
import com.nuguna.freview.customer.exception.IllegalReviewException;
import com.nuguna.freview.customer.exception.IllegalReviewPageAccessException;
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
  private final RankPointLogMapper rankPointLogMapper;

  @Autowired
  public CustomerReviewServiceImpl(CustomerReviewMapper customerReviewMapper,
      RankPointLogMapper rankPointLogMapper) {
    this.customerReviewMapper = customerReviewMapper;
    this.rankPointLogMapper = rankPointLogMapper;
  }

  @Override
  public CustomerMyReviewRegisterResponseDTO registerCustomerReview(
      Long userSeq, CustomerMyReviewRegisterRequestDTO customerMyReviewRegisterRequestDTO) {
    Long reviewSeq = customerMyReviewRegisterRequestDTO.getReviewSeq();
    String reviewUrl = customerMyReviewRegisterRequestDTO.getReviewUrl();

    if (!customerReviewMapper.checkIsValidReview(userSeq, reviewSeq)) {
      throw new IllegalReviewException("존재하지 않는 리뷰입니다.");
    }

    if (customerReviewMapper.checkAlreadyExistReview(reviewSeq)) {
      throw new AlreadyExistReviewException("이미 등록완료 처리된 리뷰입니다.");
    }

    customerReviewMapper.registerReview(reviewSeq, reviewUrl);
    rankPointLogMapper.insertPointLog(userSeq, "POST");
    return new CustomerMyReviewRegisterResponseDTO(reviewUrl);
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerMyReviewsRetrieveResponseDTO getCustomerMyReviews(
      Long userSeq, CustomerMyReviewsRetrieveRequestDTO customerMyReviewsRetrieveRequestDTO) {
    Integer currentPage = customerMyReviewsRetrieveRequestDTO.getPage();

    int offset = (currentPage - 1) * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE;
    int reviewCount = customerReviewMapper.getReviewCount(userSeq);
    if (offset > reviewCount) {
      throw new IllegalReviewPageAccessException("해당하는 페이지에 대한 리뷰가 존재하지 않습니다.");
    }
    List<ReviewLogInfoDTO> reviewsInfo = customerReviewMapper.getReviewsInfo(userSeq, offset,
        CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE);

    int startPage =
        ((currentPage - 1) / CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE)
            * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE
            + 1;
    int endPage;
    int pageBlockThreshold = startPage + CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE - 1;
    if (reviewCount >= pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE) {
      endPage = pageBlockThreshold;
    } else {
      endPage = (int) Math.ceil((double) reviewCount / CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE);
    }
    boolean hasNext = ((currentPage < endPage) || (reviewCount
        > pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE));
    boolean hasPrevious = (currentPage > 1);

    PaginationInfoResponseDTO paginationInfoResponseDTO = new PaginationInfoResponseDTO(
        currentPage, startPage, endPage, hasNext, hasPrevious);
    return new CustomerMyReviewsRetrieveResponseDTO(reviewsInfo, paginationInfoResponseDTO);
  }

  @Override
  public CustomerOtherReviewsRetrieveResponseDTO getOtherCustomerReviews(
      Long userSeq, CustomerOtherReviewsRetrieveRequestDTO customerOtherReviewsRetrieveRequestDTO) {
    Integer currentPage = customerOtherReviewsRetrieveRequestDTO.getPage();

    int offset = (currentPage - 1) * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE;
    int reviewCount = customerReviewMapper.getOtherReviewCount(userSeq);
    if (offset > reviewCount) {
      throw new IllegalReviewPageAccessException("해당하는 페이지에 대한 리뷰가 존재하지 않습니다.");
    }
    List<ReviewLogInfoDTO> reviewsInfo = customerReviewMapper.getOtherReviewsInfo(userSeq, offset,
        CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE);

    int startPage =
        ((currentPage - 1) / CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE)
            * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE
            + 1;
    int endPage;
    int pageBlockThreshold = startPage + CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_BLOCK_SIZE - 1;
    if (reviewCount >= pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE) {
      endPage = pageBlockThreshold;
    } else {
      endPage = (int) Math.ceil((double) reviewCount / CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE);
    }
    boolean hasNext = ((currentPage < endPage) || (reviewCount
        > pageBlockThreshold * CUSTOMER_MY_BRAND_REVIEW_LOG_PAGE_SIZE));
    boolean hasPrevious = (currentPage > 1);

    PaginationInfoResponseDTO paginationInfoResponseDTO = new PaginationInfoResponseDTO(
        currentPage, startPage, endPage, hasNext, hasPrevious);
    return new CustomerOtherReviewsRetrieveResponseDTO(reviewsInfo,
        paginationInfoResponseDTO);
  }
}
