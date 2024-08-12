package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.admin.mapper.ReviewMapper;
import com.nuguna.freview.admin.service.ReviewService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewMapper reviewMapper;
  private final RankPointLogMapper rankPointLogMapper;

  @Autowired
  public ReviewServiceImpl(ReviewMapper reviewMapper, RankPointLogMapper rankPointLogMapper) {
    this.reviewMapper = reviewMapper;
    this.rankPointLogMapper = rankPointLogMapper;
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
  @Transactional
  public boolean deleteReview(Long seq) {
    int result = reviewMapper.deleteReview(seq);
    int result2 = rankPointLogMapper.insertPointLog(seq, "UNPOST");
    return (result == 1 && result2 == 1);
  }
}
