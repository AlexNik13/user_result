package com.example.user_result.reposytori;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.user_result.model.UserLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLevelRepositoryImpl implements UserLevelRepository {

  private final List<UserLevel> repository;

  @Autowired
  public UserLevelRepositoryImpl(
      List<UserLevel> repository
  ) {
    this.repository = repository;
  }

  @Override
  public void save(UserLevel userLevel) {
    repository.add(userLevel);
  }

  @Override
  public List<UserLevel> findAllByUserId(int userId) {
    return repository.stream()
        .filter(user -> user.getUserId() == userId)
        .collect(Collectors.toList());
  }

  @Override
  public List<UserLevel> findAllByLevelId(int levelId) {
    return repository.stream()
        .filter(user -> user.getLevelId() == levelId)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<UserLevel> findByUserIdAndLevelId(int userId, int levelId) {
    return repository.stream()
        .filter(
            u -> u.getUserId() == userId && u.getLevelId() == levelId
        )
        .findFirst();
  }

  @Override
  public void delete(UserLevel userLeve) {
    repository.remove(userLeve);
  }

}
