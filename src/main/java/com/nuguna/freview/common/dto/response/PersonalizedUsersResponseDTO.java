package com.nuguna.freview.common.dto.response;

import com.nuguna.freview.common.dto.PersonalizedUserDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonalizedUsersResponseDTO {
  private List<PersonalizedUserDTO> userList;
}
