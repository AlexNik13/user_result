package com.example.user_result.dto.response;

import com.example.user_result.model.UserLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLevelResponse {

  @JsonProperty(value = "user_id")
  private int userId;

  @JsonProperty(value = "level_id")
  private int levelId;
  private int result;

  public static UserLevelResponse to(UserLevel userLevel) {
    return UserLevelResponse.builder()
        .userId(userLevel.getUserId())
        .levelId(userLevel.getLevelId())
        .result(userLevel.getResult())
        .build();
  }

}
