package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.response.StoreOtherReviewInfosRetrieveResponseDTO;
import com.nuguna.freview.store.service.StoreOtherBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/store/other/brand-info")
public class StoreOtherBrandInfoApiController {

  private final StoreOtherBrandService storeOtherBrandService;

  @Autowired
  public StoreOtherBrandInfoApiController(StoreOtherBrandService storeOtherBrandService) {
    this.storeOtherBrandService = storeOtherBrandService;
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.GET)
  public ResponseEntity<StoreOtherReviewInfosRetrieveResponseDTO> getOtherStoreReviewInfos(
      @RequestParam Long userSeq, @RequestParam Integer targetPage) {
    StoreOtherReviewInfosRetrieveResponseDTO responseDTO = storeOtherBrandService.getOtherStoreReviewInfos(
        userSeq, targetPage);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
