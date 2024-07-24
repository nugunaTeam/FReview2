package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.request.CustomerAgeGroupUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerFoodTypesUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerIntroduceUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerNicknameUpdateRequestDTO;
import com.nuguna.freview.customer.dto.request.CustomerTagsUpdateRequestDTO;
import com.nuguna.freview.customer.dto.response.CustomerAgeGroupUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerFoodTypesUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerIntroduceUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerNicknameUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerProfilePhotoUpdateResponseDTO;
import com.nuguna.freview.customer.dto.response.CustomerTagsUpdateResponseDTO;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerBrandService {

  CustomerNicknameUpdateResponseDTO updateCustomerNickname(
      CustomerNicknameUpdateRequestDTO customerNicknameUpdateRequestDTO);

  CustomerAgeGroupUpdateResponseDTO updateCustomerAgeGroup(
      CustomerAgeGroupUpdateRequestDTO customerAgeGroupUpdateRequestDTO);

  CustomerProfilePhotoUpdateResponseDTO updateCustomerPhotoUrl(
      Long userSeq, MultipartFile profileFile) throws IOException;

  CustomerIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerIntroduceUpdateRequestDTO customerIntroduceUpdateRequestDTO);

  CustomerFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerFoodTypesUpdateRequestDTO customerFoodTypesUpdateRequestDTO);

  CustomerTagsUpdateResponseDTO updateCustomerTags(
      CustomerTagsUpdateRequestDTO customerTagsUpdateRequestDTO);
}
