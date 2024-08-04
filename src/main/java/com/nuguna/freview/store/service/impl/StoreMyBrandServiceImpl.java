package com.nuguna.freview.store.service.impl;

import com.nuguna.freview.store.dto.request.StoreMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyStoreLocationUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyTagsUpdateRequestDTO;
import com.nuguna.freview.store.dto.response.StoreMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyStoreLocationUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyTagsUpdateResponseDTO;
import com.nuguna.freview.store.mapper.StoreMyBrandMapper;
import com.nuguna.freview.store.service.StoreMyBrandService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
public class StoreMyBrandServiceImpl implements StoreMyBrandService {

  private final StoreMyBrandMapper storeMyBrandMapper;

  @Autowired
  public StoreMyBrandServiceImpl(StoreMyBrandMapper storeMyBrandMapper) {
    this.storeMyBrandMapper = storeMyBrandMapper;
  }

  @Override
  public void updateStorePhotoUrl(Long userSeq, MultipartFile profileFile) {
  }

  @Override
  public StoreMyIntroduceUpdateResponseDTO updateStoreIntroduce(
      StoreMyIntroduceUpdateRequestDTO storeMyIntroduceUpdateRequestDTO) {
    return null;
  }

  @Override
  public StoreMyFoodTypesUpdateResponseDTO updateStoreFoodTypes(
      StoreMyFoodTypesUpdateRequestDTO storeMyFoodTypesUpdateRequestDTO) {
    Long storeSeq = storeMyFoodTypesUpdateRequestDTO.getUserSeq();
    List<String> toFoodTypes = storeMyFoodTypesUpdateRequestDTO.getToFoodTypes();

    storeMyBrandMapper.deleteFoodTypesByUserSeq(storeSeq);
    if (toFoodTypes != null && !toFoodTypes.isEmpty()) {
      storeMyBrandMapper.insertFoodTypes(storeSeq, toFoodTypes);
    }
    return new StoreMyFoodTypesUpdateResponseDTO(toFoodTypes);
  }

  @Override
  public StoreMyTagsUpdateResponseDTO updateStoreTags(
      StoreMyTagsUpdateRequestDTO storeMyTagsUpdateRequestDTO) {
    Long storeSeq = storeMyTagsUpdateRequestDTO.getUserSeq();
    List<String> toTags = storeMyTagsUpdateRequestDTO.getToTags();

    storeMyBrandMapper.deleteTagsByUserSeq(storeSeq);
    if (toTags != null && !toTags.isEmpty()) {
      storeMyBrandMapper.insertTags(storeSeq, toTags);
    }
    return new StoreMyTagsUpdateResponseDTO(toTags);
  }

  @Override
  public StoreMyStoreLocationUpdateResponseDTO updateStoreLocation(
      StoreMyStoreLocationUpdateRequestDTO storeMyStoreLocationUpdateRequestDTO) {
    Long storeSeq = storeMyStoreLocationUpdateRequestDTO.getUserSeq();
    String toStoreLocation = storeMyStoreLocationUpdateRequestDTO.getToStoreLocation();
    storeMyBrandMapper.updateStoreLocation(storeSeq, toStoreLocation);
    return new StoreMyStoreLocationUpdateResponseDTO(toStoreLocation);
  }
}
