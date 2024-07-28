package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import com.nuguna.freview.admin.mapper.ReviewMapper;
import com.nuguna.freview.admin.service.ReviewService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewMapper reviewMapper;

  @Autowired
  public ReviewServiceImpl(ReviewMapper reviewMapper) {
    this.reviewMapper = reviewMapper;
  }

  @Override
  public List<HiddenReviewDTO> getHiddenReviews(int currentPage, int pageSize) {
    int offset = (currentPage - 1) * pageSize;
    return reviewMapper.getHiddenReviews(offset, pageSize);
  }

  @Override
  public int getTotalCount() {
    return reviewMapper.selectTotalPage();
  }

  @Override
  public boolean deleteReview(Long seq) {
    int result = reviewMapper.deleteReview(seq);
    return result == 0;
  }
}
