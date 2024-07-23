package com.nuguna.freview.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {

  int checkPostLiked(@Param("userSeq") Long userSeq, @Param("postSeq") Long postSeq);
  void insertPostViewCount(@Param("postSeq") Long postSeq);
  int deletePost(Long postSeq);
  int insertLike(@Param("postSeq") Long postSeq, @Param("userSeq") Long userSeq);
  int deleteLike(@Param("postSeq") Long postSeq, @Param("userSeq") Long userSeq);
  Long selectWriterSeqByPostSeq(Long postSeq);
}