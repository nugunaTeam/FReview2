package com.nuguna.freview.store.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMyBrandMapper {

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
