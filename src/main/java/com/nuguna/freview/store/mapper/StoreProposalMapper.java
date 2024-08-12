package com.nuguna.freview.store.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreProposalMapper {

  String getUserCode(@Param("userSeq") Long userSeq);

  Boolean checkProposalExist(@Param("storeSeq") Long storeSeq,
      @Param("customerSeq") Long customerSeq);

  void makeProposalToCustomer(@Param("storeSeq") Long storeSeq,
      @Param("customerSeq") Long customerSeq, @Param("proposalDetail") String proposalDetail);

}
