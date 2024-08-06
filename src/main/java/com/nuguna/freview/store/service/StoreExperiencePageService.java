package com.nuguna.freview.store.service;

import com.nuguna.freview.store.dto.response.page.StoreApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalApplyListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreFinalProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreProposalListResponseDTO;
import com.nuguna.freview.store.dto.response.page.StoreReviewListResponseDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface StoreExperiencePageService {

  StoreApplyListResponseDTO applyList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize);

  void applyConfirm(@RequestParam Long experienceSeq);

  StoreProposalListResponseDTO proposalList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize);

  StoreFinalApplyListResponseDTO finalApplyList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize);

  StoreFinalProposalListResponseDTO finalProposalList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize);

  StoreReviewListResponseDTO storeReviewList(@RequestParam Long userSeq,
      @RequestParam Integer currentPage, @RequestParam Integer pageSize);

  void updateExperienceDate(@RequestParam Long experienceSeq);
  void updateExperienceStatus(@RequestParam Long experienceSeq, @RequestParam String status);
  void updateReviewStatus(@RequestParam Long customerSeq, @RequestParam String status);
}