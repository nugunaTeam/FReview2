package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.ExperienceApplyInfoDTO;
import com.nuguna.freview.store.dto.response.ExperienceProposalInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedLikeInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedZzimCustomerInfoDTO;
import com.nuguna.freview.store.dto.response.ReceivedZzimStoreInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreNotificationPageMapper {
  //Long storeNotificationPage(@Param("userSeq") Long userSeq);

  Integer storeNotificationPageReceivedLikeCount(@Param("userSeq") Long userSeq);
  Integer storeNotificationPageReceivedZzimCustomerCount(@Param("userSeq") Long userSeq);
  Integer storeNotificationPageReceivedZzimStoreCount(@Param("userSeq") Long userSeq);
  Integer storeNotificationPageActivityApplyCount(@Param("userSeq") Long userSeq);
  Integer storeNotificationPageActivityProposalCount(@Param("userSeq") Long userSeq);

  List<ReceivedLikeInfoDTO> storeNotificationReceivedLike(
      @Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

  List<ReceivedZzimCustomerInfoDTO> storeNotificationReceivedZzimCustomer(
      @Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

  List<ReceivedZzimStoreInfoDTO> storeNotificationReceivedZzimStore(
      @Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

  List<ExperienceApplyInfoDTO> storeNotificationExperienceApply(
      @Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

  List<ExperienceProposalInfoDTO> storeNotificationExperienceProposal(
      @Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
