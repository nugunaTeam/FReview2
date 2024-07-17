package com.nuguna.freview.customer.service.impl;

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
import com.nuguna.freview.customer.exception.AlreadyExistNicknameException;
import com.nuguna.freview.customer.mapper.CustomerBrandMapper;
import com.nuguna.freview.customer.service.CustomerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerBrandServiceImpl implements CustomerBrandService {

  private final CustomerBrandMapper customerBrandMapper;

  @Autowired
  public CustomerBrandServiceImpl(CustomerBrandMapper customerBrandMapper) {
    this.customerBrandMapper = customerBrandMapper;
  }

  @Override
  public CustomerNicknameUpdateResponseDTO updateCustomerNickname(
      CustomerNicknameUpdateRequestDTO customerNicknameUpdateRequestDTO) {

    String toNickname = customerNicknameUpdateRequestDTO.getToNickname();
    Long userSeq = customerNicknameUpdateRequestDTO.getUserSeq();
    if (customerBrandMapper.checkNicknameExist(toNickname, userSeq)) {
      throw new AlreadyExistNicknameException("이미 존재하는 닉네임입니다.");
    }
    customerBrandMapper.updateNickname(userSeq, toNickname);
    return new CustomerNicknameUpdateResponseDTO(toNickname);
  }

  @Override
  public CustomerAgeGroupUpdateResponseDTO updateCustomerAgeGroup(
      CustomerAgeGroupUpdateRequestDTO customerAgeGroupUpdateRequestDTO) {
    Long userSeq = customerAgeGroupUpdateRequestDTO.getUserSeq();
    String toAgeGroup = customerAgeGroupUpdateRequestDTO.getToAgeGroup();
    customerBrandMapper.updateAgeGroup(userSeq, toAgeGroup);
    return new CustomerAgeGroupUpdateResponseDTO(toAgeGroup);
  }

  @Override
  public CustomerProfilePhotoUpdateResponseDTO updateCustomerPhotoUrl(
      CustomerProfilePhotoUpdateRequestDTO customerProfilePhotoUpdateRequestDTO) {
    Long userSeq = customerProfilePhotoUpdateRequestDTO.getUserSeq();
    String toProfilePhotoUrl = customerProfilePhotoUpdateRequestDTO.getToProfilePhotoUrl();
    customerBrandMapper.updateProfilePhotoUrl(userSeq, toProfilePhotoUrl);
    return new CustomerProfilePhotoUpdateResponseDTO(toProfilePhotoUrl);
  }

  @Override
  public CustomerIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerIntroduceUpdateRequestDTO customerIntroduceUpdateRequestDTO) {
    return null;
  }

  @Override
  public CustomerFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerFoodTypesUpdateRequestDTO customerFoodTypesUpdateRequestDTO) {
    return null;
  }

  @Override
  public CustomerTagsUpdateResponseDTO updateCustomerTags(
      CustomerTagsUpdateRequestDTO customerTagsUpdateRequestDTO) {
    return null;
  }

  @Override
  public CustomerReviewRegisterResponseDTO registerCustomerReview(
      CustomerReviewRegisterRequestDTO customerReviewRegisterRequestDTO) {
    return null;
  }
}
