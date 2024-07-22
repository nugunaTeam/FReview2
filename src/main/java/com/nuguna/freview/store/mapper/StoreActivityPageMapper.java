package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreActivityPageMapper {
  Long storeActivityPage(@Param("userSeq") Long userSeq);
  List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
  List<StoreActivitySendZzimResponseDTO> storeActivityPageSendZzim(Long userSeq);
  List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq);
}
