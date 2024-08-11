package com.nuguna.freview.store.controller;

import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.dto.request.StoreHideReviewRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyStoreLocationUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyTagsUpdateRequestDTO;
import com.nuguna.freview.store.dto.response.StoreMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyProfileUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyStoreLocationUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyTagsUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreRecentMojipPostInfosRetrieveResponseDTO;
import com.nuguna.freview.store.dto.response.StoreReviewInfosRetrieveResponseDTO;
import com.nuguna.freview.store.service.StoreMyBrandService;
import java.io.IOException;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

  private final StoreMyBrandService storeMyBrandService;

  @Autowired
  public StoreMyBrandInfoApiController(StoreMyBrandService storeMyBrandService) {
    this.storeMyBrandService = storeMyBrandService;
  }

  @RequestMapping(value = "/recent-mojip-posts", method = RequestMethod.GET)
  public ResponseEntity<StoreRecentMojipPostInfosRetrieveResponseDTO> getRecentMojipPostInfos(
      @RequestParam Integer targetPage) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreRecentMojipPostInfosRetrieveResponseDTO responseDTO = storeMyBrandService.getStoreRecentMojipPosts(
        storeSeq, targetPage);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/reviews", method = RequestMethod.GET)
  public ResponseEntity<StoreReviewInfosRetrieveResponseDTO> getStoreReviewInfos(
      @RequestParam Integer targetPage) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreReviewInfosRetrieveResponseDTO responseDTO = storeMyBrandService.getStoreReviewInfos(
        storeSeq, targetPage);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/review/hide/{reviewSeq}", method = RequestMethod.POST)
  public ResponseEntity<Void> hideStoreReview(@PathVariable("reviewSeq") Long reviewSeq) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    storeMyBrandService.hideStoreReview(storeSeq, reviewSeq);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/profile-photo-url", method = RequestMethod.POST)
  public ResponseEntity<StoreMyProfileUpdateResponseDTO> updateStoreProfilePhoto(
      @RequestParam("profileFile") MultipartFile profileFile)
      throws IOException {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();

    if (profileFile == null || profileFile.isEmpty()) {
      throw new IllegalArgumentException("프로필 파일은 필수값입니다.");
    }

    StoreMyProfileUpdateResponseDTO storeMyProfileUpdateResponseDTO = storeMyBrandService.updateStorePhotoUrl(
        storeSeq, profileFile);
    return new ResponseEntity<>(storeMyProfileUpdateResponseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/introduce", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyIntroduceUpdateResponseDTO> updateStoreIntroduce(
      @Valid @RequestBody StoreMyIntroduceUpdateRequestDTO storeMyIntroduceUpdateRequestDTO
  ) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreMyIntroduceUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreIntroduce(storeSeq,
        storeMyIntroduceUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/food-types", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyFoodTypesUpdateResponseDTO> updateStoreFoodTypes(
      @Valid @RequestBody StoreMyFoodTypesUpdateRequestDTO storeMyFoodTypesUpdateRequestDTO
  ) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreMyFoodTypesUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreFoodTypes(storeSeq,
        storeMyFoodTypesUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/tags", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyTagsUpdateResponseDTO> updateStoreTags(
      @Valid @RequestBody StoreMyTagsUpdateRequestDTO storeMyTagsUpdateRequestDTO
  ) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreMyTagsUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreTags(storeSeq,
        storeMyTagsUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/store-location", method = RequestMethod.PUT)
  public ResponseEntity<StoreMyStoreLocationUpdateResponseDTO> updateStoreLocation(
      @Valid @RequestBody StoreMyStoreLocationUpdateRequestDTO storeMyStoreLocationUpdateRequestDTO
  ) {
    Long storeSeq = JwtContextHolder.getUserVO().getSeq();
    StoreMyStoreLocationUpdateResponseDTO responseDTO = storeMyBrandService.updateStoreLocation(storeSeq,
        storeMyStoreLocationUpdateRequestDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
