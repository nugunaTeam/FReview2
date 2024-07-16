package com.nuguna.freview.admin.vo.user;

import java.sql.Timestamp;
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
public class User {

  private Integer seq;
  private String businessNumber;
  private UserCode code;
  private String email;
  private String password;
  private String nickname;
  private String profilePhotoUrl;
  private String introduce;
  private String subEmail;
  private LoginType loginType;
  private boolean isWithdrawn;
  private AgeGroup ageGroup;
  private String storeLocation;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public String getCode() {
    return code != null ? code.getCode() : null;
  }

  public void setCode(String code) {
    this.code = UserCode.from(code);
  }

  public String getAgeGroup() {
    return ageGroup != null ? ageGroup.getAgeGroup() : null;
  }

  public void setAgeGroup(String ageGroup) {
    this.ageGroup = AgeGroup.from(ageGroup);
  }
}