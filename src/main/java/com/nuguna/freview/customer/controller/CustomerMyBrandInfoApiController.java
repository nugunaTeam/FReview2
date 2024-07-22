package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerMyAgeGroupUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyNicknameUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyProfilePhotoUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerMyTagsUpdateRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyAgeGroupUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyNicknameUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyProfilePhotoUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerMyTagsUpdateResponseDTO;
import com.nuguna.freview.customer.service.CustomerBrandService;
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
@RequestMapping("/api/customer/my/brand-info")
public class CustomerMyBrandInfoApiController {

  private final CustomerBrandService customerBrandService;

  @Autowired
  public CustomerMyBrandInfoApiController(CustomerBrandService customerBrandService) {
    this.customerBrandService = customerBrandService;
  }

  @RequestMapping(value = "/profile-photo-url", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyProfilePhotoUpdateResponseDTO> updateCustomerProfilePhoto(
      @Valid @RequestBody CustomerMyProfilePhotoUpdateRequestDTO customerMyProfilePhotoUpdateRequestDTO
  ) {
    CustomerMyProfilePhotoUpdateResponseDTO responseDTO = customerBrandService.updateCustomerPhotoUrl(
        customerMyProfilePhotoUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/nickname", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyNicknameUpdateResponseDTO> updateCustomerNickname(
      @Valid @RequestBody CustomerMyNicknameUpdateRequestDTO customerMyNicknameUpdateRequestDTO
  ) {
    CustomerMyNicknameUpdateResponseDTO responseDTO = customerBrandService.updateCustomerNickname(
        customerMyNicknameUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/age-group", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyAgeGroupUpdateResponseDTO> updateCustomerAgeGroup(
      @Valid @RequestBody CustomerMyAgeGroupUpdateRequestDTO customerMyAgeGroupUpdateRequestDTO
  ) {
    CustomerMyAgeGroupUpdateResponseDTO responseDTO = customerBrandService.updateCustomerAgeGroup(
        customerMyAgeGroupUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/introduce", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyIntroduceUpdateResponseDTO> updateCustomerIntroduce(
      @Valid @RequestBody CustomerMyIntroduceUpdateRequestDTO customerMyIntroduceUpdateRequestDTO
  ) {
    CustomerMyIntroduceUpdateResponseDTO responseDTO = customerBrandService.updateCustomerIntroduce(
        customerMyIntroduceUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/food-types", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyFoodTypesUpdateResponseDTO> updateCustomerFoodTypes(
      @Valid @RequestBody CustomerMyFoodTypesUpdateRequestDTO customerMyFoodTypesUpdateRequestDTO
  ) {
    CustomerMyFoodTypesUpdateResponseDTO responseDTO = customerBrandService.updateCustomerFoodTypes(
        customerMyFoodTypesUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/tags", method = RequestMethod.PUT)
  public ResponseEntity<CustomerMyTagsUpdateResponseDTO> updateCustomerTags(
      @Valid @RequestBody CustomerMyTagsUpdateRequestDTO customerMyTagsUpdateRequestDTO
  ) {
    CustomerMyTagsUpdateResponseDTO responseDTO = customerBrandService.updateCustomerTags(
        customerMyTagsUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
