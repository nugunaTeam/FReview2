package com.nuguna.freview.customer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerBrandMapper {

  Boolean checkNicknameExist(@Param("toNickname") String toNickname,
      @Param("userSeq") Long userSeq);

  void updateNickname(@Param("userSeq") Long userSeq, @Param("toNickname") String toNickname);

  void updateAgeGroup(@Param("userSeq") Long userSeq, @Param("toAgeGroup") String toAgeGroup);

  void updateProfilePhotoUrl(@Param("userSeq") Long userSeq,
      @Param("toProfilePhotoUrl") String toProfilePhotoUrl);

  void updateIntroduce(@Param("userSeq") Long userSeq,
      @Param("toIntroduce") String toIntroduce);

  void deleteFoodTypesByUserSeq(Long userSeq);

  void insertFoodTypes(@Param("userSeq") Long userSeq,
      @Param("toFoodTypes") List<String> toFoodTypes);

}
