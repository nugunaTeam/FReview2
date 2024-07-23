package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import java.sql.Timestamp;

public interface NoticeService {

  NoticeDetailResponseDTO getNoticeBySeq(Long postSeq);
  boolean updateNotice(Long postSeq, String title, String content, Timestamp now);
  boolean insertNotice(Long postSeq, String title, String content, Timestamp now);
  boolean deletePost(Long postSeq);
}
