package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.NoticeListDTO;
import java.util.List;

public interface BoardService {

  int getTotalCount(String postCode, String searchWord);
  List<NoticeListDTO> getNoticeList(int currentPage, int pageSize, String searchWord);
}
