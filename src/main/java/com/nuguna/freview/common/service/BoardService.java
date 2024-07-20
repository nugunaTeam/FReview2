package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.NoticePostDTO;
import java.util.List;

public interface BoardService {

  int getTotalCount(String postCode, String searchWord);
  List<NoticePostDTO> getNoticeList(int currentPage, int pageSize, String searchWord);
}
