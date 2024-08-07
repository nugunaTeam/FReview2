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

  @RequestMapping(value = "/my/brand", method = RequestMethod.GET)
  public String storeMyBrandPage(@RequestParam Long storeSeq, Model model) {
    StoreBrandInfoResponseDTO storeBrandPageInfo = storeBrandPageService.getMyBrandPageInfo(
        storeSeq);
    model.addAttribute("brandInfo", storeBrandPageInfo);
    log.info(String.valueOf(storeBrandPageInfo));
    return "store-my-brand-info";
  }

}