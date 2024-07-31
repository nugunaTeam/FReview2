package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimStoreResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreActivityPageMapper {
  Long storeActivityPage(@Param("userSeq") Long userSeq);
  List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(Long userSeq);
  List<StoreActivitySendZzimStoreResponseDTO> storeActivitySendZzimStore(Long userSeq);
  List<StoreActivitySendZzimCustomerResponseDTO> storeActivitySendZzimCustomer(Long userSeq);
  List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(Long userSeq);
}
