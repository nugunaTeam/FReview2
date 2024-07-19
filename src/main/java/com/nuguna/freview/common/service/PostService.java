package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;

import java.sql.Timestamp;

public interface PostService {

  NoticeDetailResponseDTO getNoticeBySeq(Long postSeq);
  boolean isLikedPost(Long userSeq, Long postSeq);
  void addViewCount(Long postSeq);
  boolean updateNotice(Long postSeq, String title, String content, Timestamp now);
  boolean deletePost(Long postSeq);
  boolean insertNotice(Long postSeq, String title, String content, Timestamp now);
  boolean addLikeToPost(Long postSeq, Long userSeq);
  boolean cancelLikeToPost(Long postSeq, Long userSeq);
}
