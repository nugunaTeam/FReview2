package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import java.util.List;

public interface ReviewService {

  List<HiddenReviewDTO> getHiddenReviews(int currentPage, int pageSize);
  int getTotalCount();
  boolean deleteReview(Long seq);
}
