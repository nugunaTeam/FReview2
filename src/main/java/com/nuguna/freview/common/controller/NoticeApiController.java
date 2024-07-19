package com.nuguna.freview.common.controller;

import com.nuguna.freview.admin.dto.request.NoticeInsertRequestDTO;
import com.nuguna.freview.common.dto.request.NoticeUpdateRequestDTO;
import com.nuguna.freview.common.dto.response.NoticePostDTO;
import com.nuguna.freview.common.dto.response.page.NoticeResponseDTO;
import com.nuguna.freview.common.service.BoardService;
import com.nuguna.freview.common.service.PostService;
import com.nuguna.freview.common.vo.post.PostCode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/notice")
public class NoticeApiController {

  private final BoardService boardService;
  private final PostService postService;
  private final int PAGE_SIZE = 10;

  @Autowired
  public NoticeApiController(BoardService boardService, PostService postService) {
    this.boardService = boardService;
    this.postService = postService;
  }

  @RequestMapping(value = "/list/{currentPage}", method = RequestMethod.POST)
  public NoticeResponseDTO getNoticeList(@PathVariable int currentPage, @RequestParam(value = "searchWord") String searchWord) {
    List<NoticePostDTO> noticeList = boardService.getNoticeList(currentPage, PAGE_SIZE, searchWord);
    int noticeTotal = boardService.getTotalCount(PostCode.NOTICE.getCode(), searchWord);
    int totalPage = (int)Math.ceil((double)noticeTotal / (double)PAGE_SIZE);

    NoticeResponseDTO responseDTO = new NoticeResponseDTO();
    responseDTO.setNoticeList(noticeList);
    responseDTO.setPageTotalCount(totalPage);

    return responseDTO;
  }

  //TODO: 여기도 PathVariable 로 처리할 것
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<?> updatePost(@RequestBody NoticeUpdateRequestDTO requestDTO) {
    Long postSeq = requestDTO.getSeq();
    String title = requestDTO.getTitle();
    String content = requestDTO.getContent();
    Timestamp now = Timestamp.valueOf(LocalDateTime.now());

    try {
      boolean updateResult = postService.updateNotice(postSeq, title, content, now);
      if (updateResult) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 공지글 수정 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/{deletePostSeq}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deletePost(@PathVariable Long deletePostSeq) {
    if (postService.deletePost(deletePostSeq)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<?> insertPost(@RequestBody NoticeInsertRequestDTO requestDTO) {
    Long userSeq = requestDTO.getUserSeq();
    String title = requestDTO.getTitle();
    String content = requestDTO.getContent();
    Timestamp now = Timestamp.valueOf(LocalDateTime.now());

    log.info("---" + userSeq + ", " + title + ", " + content + ", " + now.toString());

    try {
      boolean updateResult = postService.insertNotice(userSeq, title, content, now);
      if (updateResult) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 공지글 등록 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}