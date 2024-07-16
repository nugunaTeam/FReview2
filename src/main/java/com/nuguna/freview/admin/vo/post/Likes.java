package com.nuguna.freview.admin.vo.post;

import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Likes {

  private Long seq;
  private Long userSeq;
  private Long postSeq;
  private Timestamp createdAt;
}