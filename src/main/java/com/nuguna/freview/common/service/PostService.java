package com.nuguna.freview.common.service;

public interface PostService {

  boolean isLikedPost(Long userSeq, Long postSeq);
  void addViewCount(Long postSeq);
  boolean addLikeToPost(Long postSeq, Long userSeq);
  boolean cancelLikeToPost(Long postSeq, Long userSeq);
}
