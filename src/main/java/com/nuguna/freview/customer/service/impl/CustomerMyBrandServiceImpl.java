package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.global.FileUtil.getProfileDestinationFilePath;
import static com.nuguna.freview.global.FileUtil.getResizedProfileFilePath;
import static com.nuguna.freview.global.FileUtil.getSaveProfileFileName;
import static com.nuguna.freview.global.FileUtil.resizeAndSave;

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
import com.nuguna.freview.customer.exception.AlreadyExistNicknameException;
import com.nuguna.freview.customer.mapper.CustomerBrandMapper;
import com.nuguna.freview.customer.service.CustomerMyBrandService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
public class CustomerMyBrandServiceImpl implements CustomerMyBrandService {

  private final CustomerBrandMapper customerBrandMapper;

  @Autowired
  public CustomerMyBrandServiceImpl(CustomerBrandMapper customerBrandMapper) {
    this.customerBrandMapper = customerBrandMapper;
  }

  @Override
  public CustomerMyNicknameUpdateResponseDTO updateCustomerNickname(
      CustomerMyNicknameUpdateRequestDTO customerMyNicknameUpdateRequestDTO) {
    String toNickname = customerMyNicknameUpdateRequestDTO.getToNickname();
    Long userSeq = customerMyNicknameUpdateRequestDTO.getUserSeq();

    if (customerBrandMapper.checkNicknameExist(toNickname, userSeq)) {
      throw new AlreadyExistNicknameException("이미 존재하는 닉네임입니다.");
    }
    customerBrandMapper.updateNickname(userSeq, toNickname);
    return new CustomerMyNicknameUpdateResponseDTO(toNickname);
  }

  @Override
  public CustomerMyAgeGroupUpdateResponseDTO updateCustomerAgeGroup(
      CustomerMyAgeGroupUpdateRequestDTO customerMyAgeGroupUpdateRequestDTO) {
    Long userSeq = customerMyAgeGroupUpdateRequestDTO.getUserSeq();
    String toAgeGroup = customerMyAgeGroupUpdateRequestDTO.getToAgeGroup();

    customerBrandMapper.updateAgeGroup(userSeq, toAgeGroup);
    return new CustomerMyAgeGroupUpdateResponseDTO(toAgeGroup);
  }

  @Override
  public CustomerMyProfilePhotoUpdateResponseDTO updateCustomerPhotoUrl(
      Long userSeq, MultipartFile profileFile) throws IOException {

    // 저장할 프로필 파일 이름
    String saveProfileFilename = getSaveProfileFileName(profileFile.getOriginalFilename());
    // 프로필 파일 원본이 저장될 위치
    File destinationFilePath = getProfileDestinationFilePath(saveProfileFilename);
    profileFile.transferTo(destinationFilePath);

    File resizedFilePath = getResizedProfileFilePath(saveProfileFilename);
    resizeAndSave(destinationFilePath, resizedFilePath);

    customerBrandMapper.updateProfilePhotoUrl(userSeq, saveProfileFilename);
    return new CustomerMyProfilePhotoUpdateResponseDTO(saveProfileFilename);
  }

  @Override
  public CustomerMyIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerMyIntroduceUpdateRequestDTO customerMyIntroduceUpdateRequestDTO) {
    Long userSeq = customerMyIntroduceUpdateRequestDTO.getUserSeq();
    String toIntroduce = customerMyIntroduceUpdateRequestDTO.getToIntroduce();

    customerBrandMapper.updateIntroduce(userSeq, toIntroduce);
    return new CustomerMyIntroduceUpdateResponseDTO(toIntroduce);
  }

  @Override
  public CustomerMyFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerMyFoodTypesUpdateRequestDTO customerMyFoodTypesUpdateRequestDTO) {
    Long userSeq = customerMyFoodTypesUpdateRequestDTO.getUserSeq();
    List<String> toFoodTypes = customerMyFoodTypesUpdateRequestDTO.getToFoodTypes();

    customerBrandMapper.deleteFoodTypesByUserSeq(userSeq);
    if (toFoodTypes != null && !toFoodTypes.isEmpty()) {
      customerBrandMapper.insertFoodTypes(userSeq, toFoodTypes);
    }
    return new CustomerMyFoodTypesUpdateResponseDTO(toFoodTypes);
  }

  @Override
  public CustomerMyTagsUpdateResponseDTO updateCustomerTags(
      CustomerMyTagsUpdateRequestDTO customerMyTagsUpdateRequestDTO) {
    Long userSeq = customerMyTagsUpdateRequestDTO.getUserSeq();
    List<String> toTags = customerMyTagsUpdateRequestDTO.getToTags();

    customerBrandMapper.deleteTagsByUserSeq(userSeq);
    if (toTags != null && !toTags.isEmpty()) {
      customerBrandMapper.insertTags(userSeq, toTags);
    }
    return new CustomerMyTagsUpdateResponseDTO(toTags);
  }
}
