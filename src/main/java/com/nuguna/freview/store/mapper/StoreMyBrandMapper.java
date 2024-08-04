package com.nuguna.freview.store.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMyBrandMapper {

  void deleteFoodTypesByUserSeq(@Param("storeSeq") Long storeSeq);

  void insertFoodTypes(@Param("storeSeq") Long storeSeq,
      @Param("toFoodTypes") List<String> toFoodTypes);

  void deleteTagsByUserSeq(@Param("storeSeq") Long storeSeq);

  void insertTags(@Param("storeSeq") Long storeSeq, @Param("toTags") List<String> toTags);

  void updateStoreLocation(@Param("storeSeq") Long storeSeq,
      @Param("toStoreLocation") String toStoreLocation);

}
