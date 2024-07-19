package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.MojipListRequestDTO;
import com.nuguna.freview.common.dto.response.MojipPostDTO;
import com.nuguna.freview.common.dto.response.page.MojipResponseDTO;
import com.nuguna.freview.common.service.MojipService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public MojipResponseDTO getMojipList(@RequestBody MojipListRequestDTO requestDTO) {
    Long previousPostSeq = requestDTO.getPreviousPostSeq();
    String searchWord = requestDTO.getSearchWord();

    if (previousPostSeq == null) {
      previousPostSeq = Long.MAX_VALUE;
    }
    try {
      List<MojipPostDTO> mojipList = mojipService.getMojipList(previousPostSeq, searchWord, PAGE_SIZE);
      boolean hasMore = mojipList.size() == PAGE_SIZE;
      MojipResponseDTO responseDTO = new MojipResponseDTO();
      responseDTO.setMojipList(mojipList);
      responseDTO.setHasMore(hasMore);

      return responseDTO;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new MojipResponseDTO();
  }
}
