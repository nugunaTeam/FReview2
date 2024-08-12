package com.nuguna.freview.common.controller;

import com.nuguna.freview.common.dto.request.ZzimRequestDTO;
import com.nuguna.freview.common.dto.response.ZzimResponseDTO;
import com.nuguna.freview.common.service.CommonBrandService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import java.util.Objects;
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
    Long fromUserSeq = JwtContextHolder.getUserVO().getSeq();
    if(Objects.equals(fromUserSeq, zzimRequestDTO.getToUserSeq())){
      throw new IllegalArgumentException("자기 자신을 찜할 수 없습니다.");
    }
    return new ResponseEntity<>(commonBrandService.toggleZzim(fromUserSeq, zzimRequestDTO), HttpStatus.OK);
  }

}
