package com.nuguna.freview.store.service.impl;

import static com.nuguna.freview.global.FileUtil.getProfileDestinationFilePath;
import static com.nuguna.freview.global.FileUtil.getResizedProfileFilePath;
import static com.nuguna.freview.global.FileUtil.getSaveProfileFileName;
import static com.nuguna.freview.global.FileUtil.resizeAndSave;
import static com.nuguna.freview.store.constant.StoreMyBrandPageContant.STORE_RECENT_MOJIP_POST_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreMyBrandPageContant.STORE_RECENT_MOJIP_POST_PAGE_SIZE;
import static com.nuguna.freview.store.constant.StoreMyBrandPageContant.STORE_REVIEW_PAGE_BLOCK_SIZE;
import static com.nuguna.freview.store.constant.StoreMyBrandPageContant.STORE_REVIEW_PAGE_SIZE;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.util.PaginationUtil;
import com.nuguna.freview.store.dto.request.StoreMyFoodTypesUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyIntroduceUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyStoreLocationUpdateRequestDTO;
import com.nuguna.freview.store.dto.request.StoreMyTagsUpdateRequestDTO;
import com.nuguna.freview.store.dto.response.StoreMyFoodTypesUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyIntroduceUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyProfileUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyStoreLocationUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreMyTagsUpdateResponseDTO;
import com.nuguna.freview.store.dto.response.StoreRecentMojipPostInfoDTO;
import com.nuguna.freview.store.dto.response.StoreRecentMojipPostInfosRetrieveResponseDTO;
import com.nuguna.freview.store.dto.response.StoreReviewInfosRetrieveResponseDTO;
import com.nuguna.freview.store.dto.response.StoreReviewLogInfoDTO;
import com.nuguna.freview.store.mapper.StoreMyBrandMapper;
import com.nuguna.freview.store.service.StoreMyBrandService;
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
public class StoreMyBrandServiceImpl implements StoreMyBrandService {

  private final StoreMyBrandMapper storeMyBrandMapper;

  @Autowired
  public StoreMyBrandServiceImpl(StoreMyBrandMapper storeMyBrandMapper) {
    this.storeMyBrandMapper = storeMyBrandMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public StoreRecentMojipPostInfosRetrieveResponseDTO getStoreRecentMojipPosts(Long userSeq,
      int targetPage) {

    int recentMojipPostsCount = storeMyBrandMapper.getRecentMojipPostsCount(userSeq);

    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(
        targetPage, recentMojipPostsCount,
        STORE_RECENT_MOJIP_POST_PAGE_SIZE, STORE_RECENT_MOJIP_POST_PAGE_BLOCK_SIZE);

    List<StoreRecentMojipPostInfoDTO> storeRecentMojipPostInfos = storeMyBrandMapper.getStoreRecentMojipPosts(
        userSeq, (targetPage - 1) * STORE_RECENT_MOJIP_POST_PAGE_SIZE,
        STORE_RECENT_MOJIP_POST_PAGE_SIZE);

    return new StoreRecentMojipPostInfosRetrieveResponseDTO(storeRecentMojipPostInfos,
        paginationInfo);
  }

  @Override
  @Transactional(readOnly = true)
  public StoreReviewInfosRetrieveResponseDTO getStoreReviewInfos(Long userSeq, int targetPage) {

    int storeReviewsCount = storeMyBrandMapper.getStoreReviewsCount(userSeq);

    PaginationInfoResponseDTO paginationInfo = PaginationUtil.makePaginationViewInfo(targetPage,
        storeReviewsCount, STORE_REVIEW_PAGE_SIZE, STORE_REVIEW_PAGE_BLOCK_SIZE);

    List<StoreReviewLogInfoDTO> storeReviewLogInfos = storeMyBrandMapper.getStoreReviewInfos(
        userSeq, (targetPage - 1) * STORE_REVIEW_PAGE_SIZE, STORE_REVIEW_PAGE_SIZE);

    return new StoreReviewInfosRetrieveResponseDTO(storeReviewLogInfos, paginationInfo);
  }

  @Override
  public void hideStoreReview(Long userSeq, Long reviewSeq) {
    if (!storeMyBrandMapper.checkExistStoreReview(userSeq, reviewSeq)) {
      throw new IllegalArgumentException("유효한 리뷰가 아닙니다.");
    }
    storeMyBrandMapper.hideStoreReview(reviewSeq);
  }

  @Override
  public StoreMyProfileUpdateResponseDTO updateStorePhotoUrl(Long storeSeq,
      MultipartFile profileFile) throws IOException {
    // 저장할 프로필 파일 이름
    String saveProfileFilename = getSaveProfileFileName(profileFile.getOriginalFilename());
    // 프로필 파일 원본이 저장될 위치
    File destinationFilePath = getProfileDestinationFilePath(saveProfileFilename);
    profileFile.transferTo(destinationFilePath);

    File resizedFilePath = getResizedProfileFilePath(saveProfileFilename);
    resizeAndSave(destinationFilePath, resizedFilePath);

    storeMyBrandMapper.updateProfilePhotoUrl(storeSeq, saveProfileFilename);
    return new StoreMyProfileUpdateResponseDTO(saveProfileFilename);
  }

  @Override
  public StoreMyIntroduceUpdateResponseDTO updateStoreIntroduce(Long storeSeq,
      StoreMyIntroduceUpdateRequestDTO storeMyIntroduceUpdateRequestDTO) {
    String toIntroduce = storeMyIntroduceUpdateRequestDTO.getToIntroduce();

    storeMyBrandMapper.updateStoreIntroduce(storeSeq, toIntroduce);
    return new StoreMyIntroduceUpdateResponseDTO(toIntroduce);
  }

  @Override
  public StoreMyFoodTypesUpdateResponseDTO updateStoreFoodTypes(Long storeSeq,
      StoreMyFoodTypesUpdateRequestDTO storeMyFoodTypesUpdateRequestDTO) {
    List<String> toFoodTypes = storeMyFoodTypesUpdateRequestDTO.getToFoodTypes();

    storeMyBrandMapper.deleteFoodTypesByUserSeq(storeSeq);
    if (toFoodTypes != null && !toFoodTypes.isEmpty()) {
      storeMyBrandMapper.insertFoodTypes(storeSeq, toFoodTypes);
    }
    return new StoreMyFoodTypesUpdateResponseDTO(toFoodTypes);
  }

  @Override
  public StoreMyTagsUpdateResponseDTO updateStoreTags(Long storeSeq,
      StoreMyTagsUpdateRequestDTO storeMyTagsUpdateRequestDTO) {
    List<String> toTags = storeMyTagsUpdateRequestDTO.getToTags();

    storeMyBrandMapper.deleteTagsByUserSeq(storeSeq);
    if (toTags != null && !toTags.isEmpty()) {
      storeMyBrandMapper.insertTags(storeSeq, toTags);
    }
    return new StoreMyTagsUpdateResponseDTO(toTags);
  }

  @Override
  public StoreMyStoreLocationUpdateResponseDTO updateStoreLocation(Long storeSeq,
      StoreMyStoreLocationUpdateRequestDTO storeMyStoreLocationUpdateRequestDTO) {
    String toStoreLocation = storeMyStoreLocationUpdateRequestDTO.getToStoreLocation();
    storeMyBrandMapper.updateStoreLocation(storeSeq, toStoreLocation);
    return new StoreMyStoreLocationUpdateResponseDTO(toStoreLocation);
  }
}
