package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import com.nuguna.freview.common.mapper.NoticeMapper;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.NoticeService;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

  private final NoticeMapper noticeMapper;
  private final PostMapper postMapper;

  @Autowired
  public NoticeServiceImpl(NoticeMapper noticeMapper, PostMapper postMapper) {
    this.noticeMapper = noticeMapper;
    this.postMapper = postMapper;
  }

  @Override
  public NoticeDetailResponseDTO getNoticeBySeq(Long postSeq) {
    return noticeMapper.selectNotice(postSeq);
  }

  @Override
  public boolean deletePost(Long postSeq) {
    int result = postMapper.deletePost(postSeq);
    return result == 1;
  }

  @Override
  public boolean updateNotice(Long postSeq, String title, String content, Timestamp now) {
    int result = noticeMapper.updateNotice(postSeq, title, content, now);
    return result == 1;
  }

  @Override
  public boolean insertNotice(Long postSeq, String title, String content, Timestamp now) {
    int result = noticeMapper.insertNotice(postSeq, title, content, now);
    return result == 1;
  }
}
