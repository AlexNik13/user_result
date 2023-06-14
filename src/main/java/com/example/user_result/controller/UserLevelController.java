package com.example.user_result.controller;

import com.example.user_result.dto.request.UserCreateRequest;
import com.example.user_result.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PutMapping
  public ResponseEntity<Void> create(
      @RequestBody UserCreateRequest request
  ){

  }
  
}
