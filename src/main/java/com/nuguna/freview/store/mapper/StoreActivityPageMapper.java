package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.SendLikeInfoDTO;
import com.nuguna.freview.store.dto.response.SendZzimCustomerInfoDTO;
import com.nuguna.freview.store.dto.response.SendZzimStoreInfoDTO;
import com.nuguna.freview.store.dto.response.WrittenPostInfoDTO;
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

  List<SendLikeInfoDTO> storeActivityPageSendLike(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<SendZzimStoreInfoDTO> storeActivitySendZzimStore(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<SendZzimCustomerInfoDTO> storeActivitySendZzimCustomer(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<WrittenPostInfoDTO> storeActivityPageWrittenPost(@Param("userSeq") Long userSeq,
                                                      @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
