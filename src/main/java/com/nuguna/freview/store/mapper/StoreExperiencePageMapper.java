package com.nuguna.freview.store.mapper;

import com.nuguna.freview.store.dto.response.StoreApplyListDTO;
import com.nuguna.freview.store.dto.response.StoreFinalApplyListDTO;
import com.nuguna.freview.store.dto.response.StoreFinalProposalListDTO;
import com.nuguna.freview.store.dto.response.StoreProposalListDTO;
import com.nuguna.freview.store.dto.response.StoreReviewListDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreExperiencePageMapper {

  Integer getStoreApplyCount(@Param("userSeq") Long userSeq);
  Integer getStoreProposalListCount(@Param("userSeq") Long userSeq);
  Integer getStoreFinalApplyListCount(@Param("userSeq") Long userSeq);
  Integer getStoreFinalProposalListCount(@Param("userSeq") Long userSeq);
  Integer getStoreReviewListCount(@Param("userSeq") Long userSeq);

  void setStoreApplyStatus(@Param("experienceSeq") Long experienceSeq);
  void setUpdateExperienceDate(@Param("experienceSeq") Long experienceSeq);

  void setUpdateExperienceStatus(@Param("experienceSeq") Long experienceSeq, @Param("status") String status);
  void setUpdateReviewStatus(@Param("customerSeq") Long customerSeq, @Param("status") String status);

  List<StoreApplyListDTO> getStoreApplyList(@Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreProposalListDTO> getStoreProposalList(@Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreFinalApplyListDTO> getStoreFinalApplyList(@Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreFinalProposalListDTO> getStoreFinalProposalList(@Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
  List<StoreReviewListDTO> getStoreReviewList(@Param("userSeq") Long userSeq, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

}
