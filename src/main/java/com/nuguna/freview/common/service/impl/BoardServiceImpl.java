package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.NoticePostDTO;
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
  public int getTotalCount(String postCode, String searchWord) {
    if (searchWord == null) {
      return boardMapper.selectTotalPage(postCode);
    } else {
      return boardMapper.selectTotalPageWithSearchWord(postCode, searchWord);
    }
  }

  @Override
  public List<NoticePostDTO> getNoticeList(int currentPage, int pageSize, String searchWord) {
    int offset = (currentPage - 1) * pageSize;

    if (searchWord == null) {
      return boardMapper.selectNoticeList(offset, pageSize);
    } else {
      return boardMapper.searchNoticeList(offset, pageSize, searchWord);
    }
  }
}
