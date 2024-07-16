package com.nuguna.freview.customer.controller;

import com.nuguna.freview.customer.dto.request.CustomerAgeGroupUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerFoodTypesUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerIntroduceUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerNicknameUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerProfilePhotoUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerReviewRegisterRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerTagsUpdateRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerAgeGroupUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerFoodTypesUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerIntroduceUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerNicknameUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProfilePhotoUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerReviewRegisterResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerTagsUpdateResponseDTO;
import com.nuguna.freview.customer.service.CustomerBrandService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping(value = "/nickname", method = RequestMethod.PUT)
  public ResponseEntity<CustomerNicknameUpdateResponseDTO> updateCustomerNickname(
      @Valid @RequestBody CustomerNicknameUpdateRequestDTO customerNicknameUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/age-group", method = RequestMethod.PUT)
  public ResponseEntity<CustomerAgeGroupUpdateResponseDTO> updateCustomerAgeGroup(
      @Valid @RequestBody CustomerAgeGroupUpdateRequestDTO customerAgeGroupUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/profile-photo-url", method = RequestMethod.PUT)
  public ResponseEntity<CustomerProfilePhotoUpdateResponseDTO> updateCustomerProfilePhoto(
      @Valid @RequestBody CustomerProfilePhotoUpdateRequestDTO customerProfilePhotoUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/introduce", method = RequestMethod.PUT)
  public ResponseEntity<CustomerIntroduceUpdateResponseDTO> updateCustomerIntroduce(
      @Valid @RequestBody CustomerIntroduceUpdateRequestDTO customerIntroduceUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/tags", method = RequestMethod.PUT)
  public ResponseEntity<CustomerTagsUpdateResponseDTO> updateCustomerTags(
      @Valid @RequestBody CustomerTagsUpdateRequestDTO customerTagsUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/food-types", method = RequestMethod.PUT)
  public ResponseEntity<CustomerFoodTypesUpdateResponseDTO> updateCustomerFoodTypes(
      @Valid @RequestBody CustomerFoodTypesUpdateRequestDTO customerFoodTypesUpdateRequestDTO
  ) {
    return null;
  }

  @RequestMapping(value = "/review", method = RequestMethod.POST)
  public ResponseEntity<CustomerReviewRegisterResponseDTO> registerCustomerReviews(
      @Valid @RequestBody CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO
  ) {
    return null;
  }

}
