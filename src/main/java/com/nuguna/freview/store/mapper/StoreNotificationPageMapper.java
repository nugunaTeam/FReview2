package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreNotificationExperienceResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedReplyResponseDTO;
import com.nuguna.freview.store.dto.response.StoreNotificationReceivedZzimResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreNotificationPageMapper {
  String storeNotificationPage(@Param("userSeq") Long userSeq);
  List<StoreNotificationReceivedLikeResponseDTO> storeNotificationReceivedLike(Long userSeq);
  List<StoreNotificationReceivedZzimResponseDTO> storeNotificationReceivedZzim(Long userSeq);
  List<StoreNotificationReceivedReplyResponseDTO> storeNotificationReceivedReply(Long userSeq);
  List<StoreNotificationExperienceResponseDTO> storeNotificationExperience(Long userSeq);

}
