package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.PostService;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostMapper postMapper;

  @Autowired
  public PostServiceImpl(PostMapper postMapper) {
    this.postMapper = postMapper;
  }

  @Override
  public NoticeDetailResponseDTO getPostBySeq(Long postSeq) {
    return postMapper.selectNotice(postSeq);
  }

  public boolean isLikedPost(Long userSeq, Long postSeq) {
    int result = postMapper.checkPostLiked(userSeq, postSeq);
    return result == 1;
  }

  @Override
  public void addViewCount(Long postSeq) {
    postMapper.insertPostViewCount(postSeq);
  }

  @Override
  public boolean updateNotice(Long postSeq, String title, String content, Timestamp now) {
    int result = postMapper.updateNotice(postSeq, title, content, now);
    return result == 1;
  }

  @Override
  public boolean deletePost(Long postSeq) {
    int result = postMapper.deletePost(postSeq);
    return result == 1;
  }

  @Override
  public boolean insertNotice(Long postSeq, String title, String content, Timestamp now) {
    int result = postMapper.insertNotice(postSeq, title, content, now);
    return result == 1;
  }
}
