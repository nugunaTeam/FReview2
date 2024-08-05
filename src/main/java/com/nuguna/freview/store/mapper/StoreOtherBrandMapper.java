package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreOtherReviewLogInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreOtherBrandMapper {

  Integer getOtherStoreReviewsCount(@Param("storeSeq") Long storeSeq);

  List<StoreOtherReviewLogInfoDTO> getOtherStoreReviewInfos(@Param("storeSeq") Long storeSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);
}
