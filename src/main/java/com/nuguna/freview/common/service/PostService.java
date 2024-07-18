package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;

public interface PostService {

  NoticeDetailResponseDTO getPostBySeq(Long postSeq);
  boolean isLikedPost(Long userSeq, Long postSeq);

}
