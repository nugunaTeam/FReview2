package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreActivityPageMapper {
  void storeActivityPage(@Param("userSeq") Long userSeq);
  List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
}
