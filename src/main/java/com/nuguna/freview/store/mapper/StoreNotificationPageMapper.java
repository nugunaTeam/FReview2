package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceApplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationExperienceProposeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimCustomerResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimStoreResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreNotificationPageMapper {
  String storeNotificationPage(@Param("userSeq") Long userSeq);
  List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(Long userSeq);
  List<StoreNotificationReceivedZzimCustomerResponseDTO> storeNotificationReceivedZzimCustomer(Long userSeq);
  List<StoreNotificationReceivedZzimStoreResponseDTO> storeNotificationReceivedZzimStore(Long userSeq);
  List<StoreNotificationExperienceApplyResponseDTO> storeNotificationExperienceApply(Long userSeq);
  List<StoreNotificationExperienceProposeResponseDTO> storeNotificationExperiencePropose(Long userSeq);
}
