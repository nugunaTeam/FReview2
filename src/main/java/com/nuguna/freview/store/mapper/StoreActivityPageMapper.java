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
  Integer storeActivityPageSendLikeCount(@Param("userSeq") Long userSeq);
  Integer storeActivitySendZzimCustomerCount(@Param("userSeq") Long userSeq);
  Integer storeActivitySendZzimStoreCount(@Param("userSeq") Long userSeq);
  Integer storeActivityPageWrittenPostCount(@Param("userSeq") Long userSeq);

  List<StoreActivitySendLikeResponseDTO> storeActivityPageSendLike(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreActivitySendZzimStoreResponseDTO> storeActivitySendZzimStore(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreActivitySendZzimCustomerResponseDTO> storeActivitySendZzimCustomer(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreActivityWrittenPostResponseDTO> storeActivityPageWrittenPost(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
