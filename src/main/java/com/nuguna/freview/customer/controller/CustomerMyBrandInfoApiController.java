package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyAgeGroupUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyNicknameUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyTagsUpdateRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAgeGroupUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyNicknameUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyProfilePhotoUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyTagsUpdateResponseDTO;
import com.nuguna.freview.customer.service.CustomerMyBrandService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import java.io.IOException;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/customer/my/brand-info")
public class CustomerMyBrandInfoApiController {

  private final CustomerMyBrandService customerMyBrandService;

  @Autowired
  public CustomerMyBrandInfoApiController(CustomerMyBrandService customerMyBrandService) {
    this.customerMyBrandService = customerMyBrandService;
  }

  @RequestMapping(value = "/profile-photo-url", method = RequestMethod.POST)
  public ResponseEntity<CustomerMyProfilePhotoUpdateResponseDTO> updateCustomerProfilePhoto(
      @RequestParam("profileFile") MultipartFile profileFile)
      throws IOException {

    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    if (profileFile == null || profileFile.isEmpty()) {
      throw new IllegalArgumentException("프로필 파일은 필수값입니다.");
    }

    CustomerMyProfilePhotoUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerPhotoUrl(
        userSeq, profileFile);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/nickname", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyNicknameUpdateResponseDTO> updateCustomerNickname(
      @Valid @RequestBody CustomerMyNicknameUpdateRequestDTO customerMyNicknameUpdateRequestDTO
  ) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyNicknameUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerNickname(
        userSeq, customerMyNicknameUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/age-group", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyAgeGroupUpdateResponseDTO> updateCustomerAgeGroup(
      @Valid @RequestBody CustomerMyAgeGroupUpdateRequestDTO customerMyAgeGroupUpdateRequestDTO
  ) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyAgeGroupUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerAgeGroup(
        userSeq, customerMyAgeGroupUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/introduce", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyIntroduceUpdateResponseDTO> updateCustomerIntroduce(
      @Valid @RequestBody CustomerMyIntroduceUpdateRequestDTO customerMyIntroduceUpdateRequestDTO
  ) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyIntroduceUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerIntroduce(
        userSeq, customerMyIntroduceUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/food-types", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyFoodTypesUpdateResponseDTO> updateCustomerFoodTypes(
      @Valid @RequestBody CustomerMyFoodTypesUpdateRequestDTO customerMyFoodTypesUpdateRequestDTO
  ) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyFoodTypesUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerFoodTypes(
        userSeq, customerMyFoodTypesUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/tags", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyTagsUpdateResponseDTO> updateCustomerTags(
      @Valid @RequestBody CustomerMyTagsUpdateRequestDTO customerMyTagsUpdateRequestDTO
  ) {
    Long userSeq = JwtContextHolder.getUserVO().getSeq();
    CustomerMyTagsUpdateResponseDTO responseDTO = customerMyBrandService.updateCustomerTags(
        userSeq, customerMyTagsUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
