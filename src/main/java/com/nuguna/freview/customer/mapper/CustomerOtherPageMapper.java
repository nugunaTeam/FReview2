package com.nuguna.freview.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerOtherPageMapper {

  String getUserCode(@Param("userSeq") Long userSeq);

  void makeProposalToCustomer(@Param("storeSeq") Long storeSeq,
      @Param("customerSeq") Long customerSeq, @Param("proposalDetail") String proposalDetail);

}
