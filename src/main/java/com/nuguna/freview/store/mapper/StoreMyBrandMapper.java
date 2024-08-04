package com.nuguna.freview.store.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMyBrandMapper {

  void updateStoreLocation(@Param("storeSeq") Long storeSeq,
      @Param("toStoreLocation") String toStoreLocation);
}
