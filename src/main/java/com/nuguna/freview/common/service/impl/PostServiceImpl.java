package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import com.nuguna.freview.common.mapper.NoticeMapper;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.PostService;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostMapper postMapper;
  private final NoticeMapper noticeMapper;

  @Autowired
  public PostServiceImpl(PostMapper postMapper, NoticeMapper noticeMapper) {
    this.postMapper = postMapper;
    this.noticeMapper = noticeMapper;
  }

  @Override
  public NoticeDetailResponseDTO getPostBySeq(Long postSeq) {
    return noticeMapper.selectNotice(postSeq);
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
    int result = noticeMapper.updateNotice(postSeq, title, content, now);
    return result == 1;
  }

  @Override
  public boolean deletePost(Long postSeq) {
    int result = postMapper.deletePost(postSeq);
    return result == 1;
  }

  @Override
  public boolean insertNotice(Long postSeq, String title, String content, Timestamp now) {
    int result = noticeMapper.insertNotice(postSeq, title, content, now);
    return result == 1;
  }
}
