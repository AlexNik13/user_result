package com.example.user_result.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLevelCreateRequest {

  @JsonProperty(value = "user_id")
  private int userId;

  @JsonProperty(value = "level_id")
  private int levelId;
  private int result;

}
