package com.nuguna.freview.admin.mapper;

import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInterestAccumulationMapper {

  void insertScore(@Param("userSeq") Long userSeq, @Param("category") String category, @Param("dish") String dish, @Param("increment") int increment);

  void updateScore(@Param("userSeq") Long userSeq, @Param("category") String category, @Param("dish") String dish, @Param("increment") int increment);

  List<String> getExistingKeys(@Param("keys")  Set<String> keys);
}
