package com.nuguna.freview.customer.service.impl;

import static com.nuguna.freview.global.FileUtil.getProfileDestinationFilePath;
import static com.nuguna.freview.global.FileUtil.getResizedProfileFilePath;
import static com.nuguna.freview.global.FileUtil.getSaveProfileFileName;
import static com.nuguna.freview.global.FileUtil.resizeAndSave;

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
import com.nuguna.freview.customer.exception.AlreadyExistNicknameException;
import com.nuguna.freview.customer.mapper.CustomerBrandMapper;
import com.nuguna.freview.customer.service.CustomerBrandService;
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
      Long userSeq, MultipartFile profileFile) throws IOException {

    // 저장할 프로필 파일 이름
    String saveProfileFilename = getSaveProfileFileName(profileFile.getOriginalFilename());
    // 프로필 파일 원본이 저장될 위치
    File destinationFilePath = getProfileDestinationFilePath(saveProfileFilename);
    profileFile.transferTo(destinationFilePath);

    File resizedFilePath = getResizedProfileFilePath(saveProfileFilename);
    resizeAndSave(destinationFilePath, resizedFilePath);

    customerBrandMapper.updateProfilePhotoUrl(userSeq, saveProfileFilename);
    return new CustomerProfilePhotoUpdateResponseDTO(saveProfileFilename);
  }

  @Override
  public CustomerIntroduceUpdateResponseDTO updateCustomerIntroduce(
      CustomerIntroduceUpdateRequestDTO customerIntroduceUpdateRequestDTO) {
    Long userSeq = customerIntroduceUpdateRequestDTO.getUserSeq();
    String toIntroduce = customerIntroduceUpdateRequestDTO.getToIntroduce();

    customerBrandMapper.updateIntroduce(userSeq, toIntroduce);
    return new CustomerIntroduceUpdateResponseDTO(toIntroduce);
  }

  @Override
  public CustomerFoodTypesUpdateResponseDTO updateCustomerFoodTypes(
      CustomerFoodTypesUpdateRequestDTO customerFoodTypesUpdateRequestDTO) {
    Long userSeq = customerFoodTypesUpdateRequestDTO.getUserSeq();
    List<String> toFoodTypes = customerFoodTypesUpdateRequestDTO.getToFoodTypes();

    customerBrandMapper.deleteFoodTypesByUserSeq(userSeq);
    if (toFoodTypes != null && !toFoodTypes.isEmpty()) {
      customerBrandMapper.insertFoodTypes(userSeq, toFoodTypes);
    }
    return new CustomerFoodTypesUpdateResponseDTO(toFoodTypes);
  }

  @Override
  public CustomerTagsUpdateResponseDTO updateCustomerTags(
      CustomerTagsUpdateRequestDTO customerTagsUpdateRequestDTO) {
    Long userSeq = customerTagsUpdateRequestDTO.getUserSeq();
    List<String> toTags = customerTagsUpdateRequestDTO.getToTags();

    customerBrandMapper.deleteTagsByUserSeq(userSeq);
    if (toTags != null && !toTags.isEmpty()) {
      customerBrandMapper.insertTags(userSeq, toTags);
    }
    return new CustomerTagsUpdateResponseDTO(toTags);
  }
}
