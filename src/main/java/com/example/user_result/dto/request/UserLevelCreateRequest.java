package com.example.user_result.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

  private int user_id;
  private int level_id;
  private int result;

}
