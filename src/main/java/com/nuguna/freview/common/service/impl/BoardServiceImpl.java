package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.NoticeListDTO;
import com.nuguna.freview.common.mapper.BoardMapper;
import com.nuguna.freview.common.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;

  @Autowired
  public BoardServiceImpl(BoardMapper boardMapper) {
    this.boardMapper = boardMapper;
  }

  @Override
  public int getTotalCount(String postCode) {
    return boardMapper.selectTotalPage(postCode);
  }

  @Override
  public List<NoticeListDTO> getNoticeList(int currentPage, int pageSize) {
    int offset = (currentPage - 1) * pageSize;
    return boardMapper.selectNoticeList(offset, pageSize);
  }
}
