package com.example.user_result.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.user_result.dto.request.UserLevelCreateRequest;
import com.example.user_result.dto.response.UserLevelResponse;
import com.example.user_result.model.UserLevel;
import com.example.user_result.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLevelController {

  private final UserLevelService userLevelService;

  @Autowired
  public UserLevelController(UserLevelService userLevelService) {
    this.userLevelService = userLevelService;
  }

  @GetMapping("/userinfo/{user_id}")
  public ResponseEntity<List<UserLevelResponse>> getTop20ResultById(
      @PathVariable(name = "user_id") int userId
  ) {
    List<UserLevel> topResult = userLevelService.getTop20ResultByUserId(userId);

    List<UserLevelResponse> resultList = topResult.stream()
        .map(UserLevelResponse::to)
        .collect(Collectors.toList());

    return ResponseEntity.ok()
        .body(resultList);
  }

  @GetMapping("/levelinfo/{level_id}")
  public ResponseEntity<List<UserLevelResponse>> getTop20UserByResult(
      @PathVariable(name = "level_id") int levelId
  ) {
    List<UserLevel> topUser = userLevelService.getTop20UserByResult(levelId);

    List<UserLevelResponse> resultList = topUser.stream()
        .map(UserLevelResponse::to)
        .collect(Collectors.toList());

    return ResponseEntity.ok()
        .body(resultList);
  }

  @PutMapping("/setinfo")
  public ResponseEntity<UserLevelResponse> create(
      @RequestBody UserLevelCreateRequest request
  ) {
    UserLevel userLevel = userLevelService.create(request);
    UserLevelResponse response = UserLevelResponse.to(userLevel);

    return ResponseEntity.ok()
        .body(response);
  }

}
