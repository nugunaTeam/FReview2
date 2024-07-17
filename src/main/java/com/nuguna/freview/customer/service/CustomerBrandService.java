package com.nuguna.freview.customer.service;

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

public interface CustomerBrandService {

  CustomerNicknameUpdateResponseDTO updateCustomerNickname(
      CustomerNicknameUpdateRequestDTO customerNicknameUpdateRequestDTO);

  CustomerAgeGroupUpdateResponseDTO updateCustomerAgeGroup(
      CustomerAgeGroupUpdateRequestDTO customerAgeGroupUpdateRequestDTO);

  CustomerProfilePhotoUpdateResponseDTO updateCustomerPhotoUrl(
      CustomerProfilePhotoUpdateRequestDTO customerProfilePhotoUpdateRequestDTO);

  CustomerIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerIntroduceUpdateRequestDTO customerIntroduceUpdateRequestDTO);

  CustomerFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerFoodTypesUpdateRequestDTO customerFoodTypesUpdateRequestDTO);

  CustomerTagsUpdateResponseDTO updateCustomerTags(
      CustomerTagsUpdateRequestDTO customerTagsUpdateRequestDTO);

  CustomerReviewRegisterResponseDTO registerCustomerReview(
      CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO);
}
