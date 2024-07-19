package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.PostLikeRequestDTO;
import com.nuguna.freview.common.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/post")
public class PostApiController {

  private final PostService postService;

  @Autowired
  public PostApiController(PostService postService) {
    this.postService = postService;
  }

  @RequestMapping(value = "/like-add", method = RequestMethod.POST)
  public ResponseEntity<?> addLikeToPost(@RequestBody PostLikeRequestDTO requestDTO) {
    Long postSeq = requestDTO.getPostSeq();
    Long userSeq = requestDTO.getUserSeq();

    try {
      boolean result = postService.addLikeToPost(postSeq, userSeq);
      if (result) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 게시글 좋아요 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/like-cancel", method = RequestMethod.DELETE)
  public ResponseEntity<?> cancelLikeToPost(@RequestBody PostLikeRequestDTO requestDTO) {
    Long postSeq = requestDTO.getPostSeq();
    Long userSeq = requestDTO.getUserSeq();

    try {
      boolean result = postService.cancelLikeToPost(postSeq, userSeq);
      if (result) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 게시글 좋아요 취소 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
