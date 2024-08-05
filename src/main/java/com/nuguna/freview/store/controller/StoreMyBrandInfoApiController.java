package com.nuguna.freview.store.controller;

import com.nuguna.freview.store.dto.request.StoreMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyStoreLocationUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyTagsUpdateRequestDTO;
import com.nuguna.freview.store.dto.response.StoreMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyProfileUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyStoreLocationUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyTagsUpdateResponseDTO;
import com.nuguna.freview.store.service.StoreMyBrandService;
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
@RequestMapping("/api/store/my/brand-info")
public class StoreMyBrandInfoApiController {

  // TODO : 수정 API 만들기 ( 프로필 사진, 소개글, 활동 분야, 태그, 위치 수정 API ) => OK
  // TODO : AJAX로 리뷰리스트 들고오기 (1)
  // TODO : AJAX로 STORE_HIDDEN 처리할 수 있도록 하기 (2)
  // TODO : AJAX로 모집 중인 글 리스트 들고오기 (3)
  private final StoreMyBrandService storeMyBrandService;

  @Autowired
  public StoreMyBrandInfoApiController(StoreMyBrandService storeMyBrandService) {
    this.storeMyBrandService = storeMyBrandService;
  }

  @RequestMapping(value = "/profile-photo-url", method = RequestMethod.POST)
  public ResponseEntity<StoreMyProfileUpdateResponseDTO> updateStoreProfilePhoto(
      @RequestParam("userSeq") Long userSeq,
      @RequestParam("profileFile") MultipartFile profileFile)
      throws IOException {

    if (profileFile == null || profileFile.isEmpty()) {
      throw new IllegalArgumentException("프로필 파일은 필수값입니다.");
    }

    StoreMyProfileUpdateResponseDTO storeMyProfileUpdateResponseDTO = storeMyBrandService.updateStorePhotoUrl(
        userSeq, profileFile);
    return new ResponseEntity<>(storeMyProfileUpdateResponseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/introduce", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyIntroduceUpdateResponseDTO> updateStoreIntroduce(
      @Valid @RequestBody StoreMyIntroduceUpdateRequestDTO storeMyIntroduceUpdateRequestDTO
  ) {
    StoreMyIntroduceUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreIntroduce(
        storeMyIntroduceUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/food-types", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyFoodTypesUpdateResponseDTO> updateStoreFoodTypes(
      @Valid @RequestBody StoreMyFoodTypesUpdateRequestDTO storeMyFoodTypesUpdateRequestDTO
  ) {
    StoreMyFoodTypesUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreFoodTypes(
        storeMyFoodTypesUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/tags", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyTagsUpdateResponseDTO> updateStoreTags(
      @Valid @RequestBody StoreMyTagsUpdateRequestDTO storeMyTagsUpdateRequestDTO
  ) {
    StoreMyTagsUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreTags(
        storeMyTagsUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/store-location", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyStoreLocationUpdateResponseDTO> updateStoreLocation(
      @Valid @RequestBody StoreMyStoreLocationUpdateRequestDTO storeMyStoreLocationUpdateRequestDTO
  ) {
    StoreMyStoreLocationUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreLocation(
        storeMyStoreLocationUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
