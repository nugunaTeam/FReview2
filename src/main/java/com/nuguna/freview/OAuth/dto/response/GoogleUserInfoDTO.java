package com.nuguna.freview.OAuth.dto.response;

import lombok.Data;

@Data
public class GoogleUserInfoDTO {
     private String email;
     private String given_name;
     private String verified_email;
     private String name;
     private String id;
     private String picture;
     private String family_name;
}
