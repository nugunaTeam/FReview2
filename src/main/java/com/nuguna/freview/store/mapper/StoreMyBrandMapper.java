package com.nuguna.freview.store.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMyBrandMapper {

  void updateStoreLocation(@Param("storeSeq") Long storeSeq,
      @Param("toStoreLocation") String toStoreLocation);

  void deleteTagsByUserSeq(@Param("storeSeq") Long storeSeq);

  void insertTags(@Param("storeSeq") Long storeSeq, @Param("toTags") List<String> toTags);
}
