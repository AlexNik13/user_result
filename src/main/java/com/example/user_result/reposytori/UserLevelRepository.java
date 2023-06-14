package com.example.user_result.reposytori;

import java.util.List;
import java.util.Optional;

import com.example.user_result.model.UserLevel;

public interface UserLevelRepository {

  void save(UserLevel userLevel);

  List<UserLevel> findAllByUserId(int userId);

  List<UserLevel> findAllByLevelId(int levelId);

  Optional<UserLevel> findByUserIdAndLevelId(int userId, int levelId);

  void delete(UserLevel userLeve);

}
