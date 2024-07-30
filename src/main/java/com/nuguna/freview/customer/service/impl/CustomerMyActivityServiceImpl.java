package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.customer.constant.CustomerLikePostConstant.CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.customer.constant.CustomerLikePostConstant.CUSTOMER_LIKE_POST_SIZE;
import static com.nuguna.freview.customer.constant.CustomerReviewLogConstant.CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE;

import com.nuguna.freview.customer.dto.request.CustomerMyLikedPostsRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedCustomersRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyZzimedStoresRetrieveRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyLikedPostsRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedCustomersResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyZzimedStoresRetrieveResponseDTO;
import com.nuguna.freview.customer.dto.response.MyLikePostInfoDTO;
import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.exception.IllegalReviewPageAccessException;
import com.nuguna.freview.customer.mapper.CustomerMyActivityMapper;
import com.nuguna.freview.customer.service.CustomerMyActivityService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerMyActivityServiceImpl implements CustomerMyActivityService {

  private final CustomerMyActivityMapper customerMyActivityMapper;

  @Autowired
  public CustomerMyActivityServiceImpl(CustomerMyActivityMapper customerMyActivityMapper) {
    this.customerMyActivityMapper = customerMyActivityMapper;
  }

  @Override
  public CustomerMyLikedPostsRetrieveResponseDTO getMyLikedPosts(Long userSeq,
      CustomerMyLikedPostsRetrieveRequestDTO customerMyLikedPostsRetrieveRequestDTO) {
    Integer targetPage = customerMyLikedPostsRetrieveRequestDTO.getTargetPage();

    int offset = (targetPage - 1) * CUSTOMER_LIKE_POST_SIZE;
    int likesCount = customerMyActivityMapper.getLikesCount(userSeq);
    if (offset > likesCount) {
      throw new IllegalReviewPageAccessException("해당하는 페이지에 대한 리뷰가 존재하지 않습니다.");
    }

    int startPage =
        ((targetPage - 1) / CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE)
            * CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE
            + 1;
    int endPage;
    int pageBlockThreshold = startPage + CUSTOMER_LIKE_POST_PAGE_BLOCK_SIZE - 1;
    if (likesCount >= pageBlockThreshold * CUSTOMER_LIKE_POST_SIZE) {
      endPage = pageBlockThreshold;
    } else {
      endPage = (int) Math.ceil((double) likesCount / CUSTOMER_LIKE_POST_SIZE);
    }
    boolean hasNext = ((targetPage < endPage) || (likesCount
        > pageBlockThreshold * CUSTOMER_LIKE_POST_SIZE));
    boolean hasPrevious = (targetPage > 1);

    PaginationInfoResponseDTO paginationInfoResponseDTO = new PaginationInfoResponseDTO(
        targetPage, startPage, endPage, hasNext, hasPrevious);

    List<MyLikePostInfoDTO> myLikedPostInfos = customerMyActivityMapper.getMyLikedPosts(userSeq,
        offset,
        CUSTOMER_MY_BRAND_REVIEW_LOG_SIZE);

    return new CustomerMyLikedPostsRetrieveResponseDTO(myLikedPostInfos, paginationInfoResponseDTO);
  }

  @Override
  public CustomerMyZzimedStoresRetrieveResponseDTO getMyZzimedStores(Long userSeq,
      CustomerMyZzimedStoresRetrieveRequestDTO customerMyZzimedStoresRetrieveRequestDTO) {
    return null;
  }

  @Override
  public CustomerMyZzimedCustomersResponseDTO getMyZzimedCustomers(Long userSeq,
      CustomerMyZzimedCustomersRetrieveRequestDTO customerMyZzimedCustomersRetrieveRequestDTO) {
    return null;
  }


}
