package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.admin.mapper.LikeLogMapper;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

  private final PostMapper postMapper;
  private final LikeLogMapper likeMapper;

  @Autowired
  public PostServiceImpl(PostMapper postMapper, LikeLogMapper likeMapper) {
    this.postMapper = postMapper;
    this.likeMapper = likeMapper;
  }

  @Override
  public boolean isLikedPost(Long userSeq, Long postSeq) {
    int result = postMapper.checkPostLiked(userSeq, postSeq);
    return result > 0;
  }

  @Override
  public void addViewCount(Long postSeq) {
    postMapper.insertPostViewCount(postSeq);
  }

  @Override
  @Transactional
  public boolean addLikeToPost(Long postSeq, Long userSeq) {
    int result = postMapper.insertLike(postSeq, userSeq);
    int result2 = likeMapper.insertLikeLog(postSeq, userSeq, "LIKE");
    return result == 1 && result2 == 1;
  }

  @Override
  @Transactional
  public boolean cancelLikeToPost(Long postSeq, Long userSeq) {
    int result = postMapper.deleteLike(postSeq, userSeq);
    int result2 = likeMapper.insertLikeLog(postSeq, userSeq, "DISLIKE");
    return result == 1 && result2 == 1;
  }
}
