package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.response.StoreBrandInfoResponseDTO;
import com.nuguna.freview.store.service.StoreBrandPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/store")
public class StoreBrandPageController {

  private final StoreBrandPageService storeBrandPageService;

  @Autowired
  public StoreBrandPageController(StoreBrandPageService storeBrandPageService) {
    this.storeBrandPageService = storeBrandPageService;
  }

  // TODO : (스토어명은 수정 불가)
  // TODO : 수정 API 만들기 ( 소개글, 활동 분야, 태그, 위치 수정 API )
  // TODO : 찜 하기/ 찜 취소 API 연동
  // TODO : AJAX로 리뷰리스트 들고오기 (1)
  // TODO : AJAX로 STORE_HIDDEN 처리할 수 있도록 하기 ( API )
  // TODO : AJAX로 모집 중인 글 리스트 들고오기 (2)
  // TODO : 사진첩은 X
  @RequestMapping(value = "/my/brand", method = RequestMethod.GET)
  public String storeMyBrandPage(@RequestParam Long storeSeq, Model model) {
    StoreBrandInfoResponseDTO storeBrandPageInfo = storeBrandPageService.getMyBrandPageInfo(
        storeSeq);
    model.addAttribute("brandInfo", storeBrandPageInfo);
    log.info(String.valueOf(storeBrandPageInfo));
    return "store-my-brand-info";
  }

}