package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreRecentMojipPostInfoDTO;
import com.nuguna.freview.store.dto.response.StoreReviewLogInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMyBrandMapper {

  Integer getRecentMojipPostsCount(@Param("storeSeq") Long storeSeq);

  List<StoreRecentMojipPostInfoDTO> getStoreRecentMojipPosts(@Param("storeSeq") Long storeSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Integer getStoreReviewsCount(@Param("storeSeq") Long storeSeq);

  List<StoreReviewLogInfoDTO> getStoreReviewInfos(@Param("storeSeq") Long storeSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Boolean checkExistStoreReview(@Param("storeSeq") Long storeSeq,
      @Param("reviewSeq") Long reviewSeq);

  void hideStoreReview(@Param("reviewSeq") Long reviewSeq);

  void updateProfilePhotoUrl(@Param("storeSeq") Long storeSeq,
      @Param("profilePhotoUrl") String profilePhotoUrl);

  void updateStoreIntroduce(@Param("storeSeq") Long storeSeq,
      @Param("toIntroduce") String toIntroduce);

  void deleteFoodTypesByUserSeq(@Param("storeSeq") Long storeSeq);

  void insertFoodTypes(@Param("storeSeq") Long storeSeq,
      @Param("toFoodTypes") List<String> toFoodTypes);

  void deleteTagsByUserSeq(@Param("storeSeq") Long storeSeq);

  void insertTags(@Param("storeSeq") Long storeSeq, @Param("toTags") List<String> toTags);

  void updateStoreLocation(@Param("storeSeq") Long storeSeq,
      @Param("toStoreLocation") String toStoreLocation);

}
