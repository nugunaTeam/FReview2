package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.MyApplyInfoDTO;
import com.nuguna.freview.customer.dto.response.ProposalToMeInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMyExperienceMapper {

  Integer getMyApplyInfosCount(@Param("userSeq") Long userSeq);

  List<MyApplyInfoDTO> getMyApplyInfos(@Param("userSeq") Long userSeq, @Param("offset") int offset,
      @Param("pageSize") int pageSize);

  Integer getProposalToMeInfosCount(@Param("userSeq") Long userSeq);

  List<ProposalToMeInfoDTO> getProposalToMeInfos(@Param("userSeq") Long userSeq,
      @Param("offset") int offset,
      @Param("pageSize") int pageSize);
}
