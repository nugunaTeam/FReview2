package com.nuguna.freview.store.service;

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
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface StoreMyBrandService {

  StoreReviewInfosRetrieveResponseDTO getStoreReviewInfos(Long userSeq, int targetPage);

  StoreRecentMojipPostInfosRetrieveResponseDTO getStoreRecentMojipPosts(Long userSeq,
      int targetPage);

  void hideStoreReview(Long userSeq, Long reviewSeq);

  StoreMyProfileUpdateResponseDTO updateStorePhotoUrl(Long storeSeq, MultipartFile profileFile)
      throws IOException;

  StoreMyIntroduceUpdateResponseDTO updateStoreIntroduce(
      StoreMyIntroduceUpdateRequestDTO storeMyIntroduceUpdateRequestDTO);

  StoreMyFoodTypesUpdateResponseDTO updateStoreFoodTypes(
      StoreMyFoodTypesUpdateRequestDTO storeMyFoodTypesUpdateRequestDTO);

  StoreMyTagsUpdateResponseDTO updateStoreTags(
      StoreMyTagsUpdateRequestDTO storeMyTagsUpdateRequestDTO);

  StoreMyStoreLocationUpdateResponseDTO updateStoreLocation(
      StoreMyStoreLocationUpdateRequestDTO storeMyStoreLocationUpdateRequestDTO);
}
