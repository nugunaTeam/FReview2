package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.response.NoticeListDTO;
import com.nuguna.freview.common.dto.response.page.NoticeResponseDTO;
import com.nuguna.freview.common.service.BoardService;
import com.nuguna.freview.common.vo.post.PostCode;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/notice")
public class NoticeBoardApiController {

  private final BoardService boardService;
  private final int PAGE_SIZE = 10;

  @Autowired
  public NoticeBoardApiController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping(value = "/list/{currentPage}", method = RequestMethod.GET)
  public NoticeResponseDTO getNoticeList(@PathVariable int currentPage) {
    List<NoticeListDTO> noticeList = boardService.getNoticeList(currentPage, PAGE_SIZE);
    int noticeTotal = boardService.getTotalPage(PostCode.NOTICE.getCode());
    int totalPage = (int)Math.ceil((double)noticeTotal / (double)PAGE_SIZE);

    NoticeResponseDTO responseDTO = NoticeResponseDTO.builder()
        .noticeList(noticeList)
        .pageTotalCount(totalPage)
        .build();

    return responseDTO;
  }
}
