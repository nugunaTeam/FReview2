package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreBrandInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreBrandPageMapper {

  StoreBrandInfoResponseDTO getStoreBrandInfo(@Param("storeSeq") Long storeSeq);
}
