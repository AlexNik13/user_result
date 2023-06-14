package com.example.user_result.service;

import java.util.List;

import com.example.user_result.dto.request.UserLevelCreateRequest;
import com.example.user_result.model.UserLevel;

public interface UserLevelService {

  UserLevel create(UserLevelCreateRequest request);

  List<UserLevel> getTop20ResultByUserId(int userId);

  List<UserLevel> getTop20UserByResult(int levelId);

}
