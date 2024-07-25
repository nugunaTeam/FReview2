package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.MojipApplyRequestDTO;
import com.nuguna.freview.common.dto.request.MojipInsertRequestDTO;
import com.nuguna.freview.common.dto.request.MojipListRequestDTO;
import com.nuguna.freview.common.dto.request.MojipUpdateRequestDTO;
import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.dto.response.page.MojipResponseDTO;
import com.nuguna.freview.common.service.MojipService;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/mojip")
public class MojipApiController {

  private final MojipService mojipService;
  private final int PAGE_SIZE = 12;

  @Autowired
  public MojipApiController(MojipService mojipService) {
    this.mojipService = mojipService;
  }

  //TODO: 모집글의 지원자 수 함께 보여주기
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public MojipResponseDTO getMojipList(@RequestBody MojipListRequestDTO requestDTO) {
    Long requesterSeq = requestDTO.getRequesterSeq();
    Long previousPostSeq = requestDTO.getPreviousPostSeq();
    String searchWord = requestDTO.getSearchWord();
    if (previousPostSeq == null) {
      previousPostSeq = Long.MAX_VALUE;
    }
      List<MojipPostDetailDTO> mojipList = mojipService.getMojipList(requesterSeq, previousPostSeq, searchWord, PAGE_SIZE);
      boolean hasMore = mojipList.size() == PAGE_SIZE;
      MojipResponseDTO responseDTO = new MojipResponseDTO();
      responseDTO.setMojipList(mojipList);
      responseDTO.setHasMore(hasMore);

      return responseDTO;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<?> createMojipPost(@RequestBody MojipInsertRequestDTO requestDTO) {
    Long userSeq = requestDTO.getUserSeq();
    String title = requestDTO.getTitle();
    Date applyStartDate = requestDTO.getApplyStartDate();
    Date applyEndDate = requestDTO.getApplyEndDate();
    Date experienceDate = requestDTO.getExperienceDate();
    String content = requestDTO.getContent();

    try {
      boolean result = mojipService.createMojip(userSeq, title, applyStartDate, applyEndDate, experienceDate, content);
      if (result) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 모집글 등록 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<?> updateMojipPost(@RequestBody MojipUpdateRequestDTO requestDTO) {
    Long postSeq = requestDTO.getPostSeq();
    String title = requestDTO.getTitle();
    String content = requestDTO.getContent();

    try {
      boolean result = mojipService.updateMojip(postSeq, title, content);
      if (result) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 모집글 수정 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/{deletePostSeq}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteMojipPost(@PathVariable Long deletePostSeq) {
    if (mojipService.deletePost(deletePostSeq)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //TODO: 이미 지원한 모집글은 지원불가 옵션 추가
  @RequestMapping(value = "/apply", method = RequestMethod.POST)
  public ResponseEntity<?> applyMojipPost(@RequestBody MojipApplyRequestDTO requestDTO) {
    Long fromUserSeq = requestDTO.getFromUserSeq();
    Long toUserSeq = requestDTO.getToUserSeq();
    Long fromPostSeq = requestDTO.getFromPostSeq();

    try {
      boolean result = mojipService.applyMojip(fromUserSeq, toUserSeq, fromPostSeq);
      if (result) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      log.error("[ERROR] 모집글 지원 도중 에러 발생", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
