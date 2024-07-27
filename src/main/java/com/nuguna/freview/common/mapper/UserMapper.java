package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import com.nuguna.freview.common.vo.user.UserVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  void insertCustomer(UserVO uservo);
  UserVO selectUser(@Param("userSeq") Long userSeq);
  List<PersonalizedUserDTO> findByDish(String dish);
  List<PersonalizedUserDTO> findByCategoryExcludingDish(@Param("category") String category, @Param("dish") String dish);
  List<PersonalizedUserDTO> findRandomUsers(@Param("limit") int limit);
}
