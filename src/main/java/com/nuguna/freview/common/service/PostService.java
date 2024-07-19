package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;

import java.sql.Timestamp;

public interface PostService {

  NoticeDetailResponseDTO getPostBySeq(Long postSeq);
  boolean isLikedPost(Long userSeq, Long postSeq);
  void addViewCount(Long postSeq);
  boolean updateNotice(Long postSeq, String title, String content, Timestamp now);
}
