package com.nuguna.freview.customer.service;

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

public interface CustomerBrandService {

  CustomerMyNicknameUpdateResponseDTO updateCustomerNickname(
      CustomerMyNicknameUpdateRequestDTO customerMyNicknameUpdateRequestDTO);

  CustomerMyAgeGroupUpdateResponseDTO updateCustomerAgeGroup(
      CustomerMyAgeGroupUpdateRequestDTO customerMyAgeGroupUpdateRequestDTO);

  CustomerMyProfilePhotoUpdateResponseDTO updateCustomerPhotoUrl(
      CustomerMyProfilePhotoUpdateRequestDTO customerMyProfilePhotoUpdateRequestDTO);

  CustomerMyIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerMyIntroduceUpdateRequestDTO customerMyIntroduceUpdateRequestDTO);

  CustomerMyFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerMyFoodTypesUpdateRequestDTO customerMyFoodTypesUpdateRequestDTO);

  CustomerMyTagsUpdateResponseDTO updateCustomerTags(
      CustomerMyTagsUpdateRequestDTO customerMyTagsUpdateRequestDTO);
}
