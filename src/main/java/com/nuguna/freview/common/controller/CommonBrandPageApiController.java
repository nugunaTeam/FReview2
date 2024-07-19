package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.ZzimRequestDTO;
import com.nuguna.freview.common.dto.response.ZzimResponseDTO;
import com.nuguna.freview.common.service.CommonBrandService;
import javax.validation.Valid;
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
@RequestMapping("/api/other")
public class CommonBrandPageApiController {

  private final CommonBrandService commonBrandService;

  @Autowired
  public CommonBrandPageApiController(CommonBrandService commonBrandService) {
    this.commonBrandService = commonBrandService;
  }

  @RequestMapping(value = "/zzim", method = RequestMethod.POST)
  public ResponseEntity<ZzimResponseDTO> zzimToggle(
      @Valid @RequestBody ZzimRequestDTO zzimRequestDTO) {
    return new ResponseEntity<>(commonBrandService.toggleZzim(zzimRequestDTO), HttpStatus.OK);
  }

}
