package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import com.nuguna.freview.admin.dto.response.page.HiddenReviewResponseDTO;
import com.nuguna.freview.admin.service.ReviewService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/experience")
public class ExperienceManageApiController {

  private final ReviewService reviewService;
  private final int PAGE_SIZE = 10;

  @Autowired
  public ExperienceManageApiController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @RequestMapping(value = "/hidden-reviews/{currentPage}")
  public HiddenReviewResponseDTO getHiddenReviews(@PathVariable int currentPage) {
    List<HiddenReviewDTO> reviews = reviewService.getHiddenReviews(currentPage, PAGE_SIZE);
    int reviewTotal = reviewService.getTotalCount();
    int totalPage = (int)Math.ceil((double)reviewTotal / (double)PAGE_SIZE);
    return new HiddenReviewResponseDTO(reviews, totalPage);
  }

  @RequestMapping(value = "/{seq}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteReview(@PathVariable Long seq) {
    if (reviewService.deleteReview(seq)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
