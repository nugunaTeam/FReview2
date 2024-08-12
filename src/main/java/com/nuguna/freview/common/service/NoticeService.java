package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.NoticePostDTO;
import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import java.sql.Timestamp;
import java.util.List;

public interface NoticeService {

  NoticeDetailResponseDTO getNoticeBySeq(Long postSeq);
  boolean updateNotice(Long postSeq, String title, String content, Timestamp now);
  boolean insertNotice(Long postSeq, String title, String content, Timestamp now);
  boolean deletePost(Long postSeq);
  List<NoticePostDTO> getNoticeList(int currentPage, int pageSize, String searchWord);
}
