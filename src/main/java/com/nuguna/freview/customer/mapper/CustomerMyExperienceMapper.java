package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.AcceptedProposalToMeInfoDTO;
import com.nuguna.freview.customer.dto.response.MyAcceptedApplyInfoDTO;
import com.nuguna.freview.customer.dto.response.MyApplyInfoDTO;
import com.nuguna.freview.customer.dto.response.ProposalToMeInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMyExperienceMapper {

  Integer getMyApplyInfosCount(@Param("userSeq") Long userSeq);

  List<MyApplyInfoDTO> getMyApplyInfos(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Integer getProposalToMeInfosCount(@Param("userSeq") Long userSeq);

  List<ProposalToMeInfoDTO> getProposalToMeInfos(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Integer getMyAcceptedApplyInfosCount(@Param("userSeq") Long userSeq);

  List<MyAcceptedApplyInfoDTO> getMyAcceptedApplyInfos(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Integer getAcceptedProposalToMeInfosCount(@Param("userSeq") Long userSeq);

  List<AcceptedProposalToMeInfoDTO> getAcceptedProposalToMeInfos(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Boolean checkExistProposalToMe(@Param("userSeq") Long userSeq,
      @Param("experienceSeq") Long experienceSeq);

  void acceptProposalToMe(@Param("experienceSeq") Long experienceSeq);

  void rejectProposalToMe(@Param("experienceSeq") Long experienceSeq);
}
