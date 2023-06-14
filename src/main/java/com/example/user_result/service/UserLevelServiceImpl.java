package com.example.user_result.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.user_result.dto.request.UserLevelCreateRequest;
import com.example.user_result.model.UserLevel;
import com.example.user_result.reposytori.UserLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLevelServiceImpl implements UserLevelService {

  private final UserLevelRepository userLevelRepository;

  @Autowired
  public UserLevelServiceImpl(
      UserLevelRepository userLevelRepository
  ) {
    this.userLevelRepository = userLevelRepository;
  }


  @Override
  public UserLevel create(UserLevelCreateRequest request) {
    final int userId = request.getUserId();
    final int levelId = request.getLevelId();
    final int result = request.getResult();

    final Optional<UserLevel> existingUserLevel
        = userLevelRepository.findByUserIdAndLevelId(userId, levelId);

    UserLevel userLevel = new UserLevel();
    userLevel.setUserId(request.getUserId());
    userLevel.setLevelId(request.getLevelId());
    userLevel.setResult(request.getResult());

    if (existingUserLevel.isPresent()) {
      final UserLevel userLeveFind = existingUserLevel.get();

      if (userLeveFind.getResult() < result) {
        userLevelRepository.delete(userLeveFind);
        userLevelRepository.save(userLevel);
        return userLevel;
      } else {
        return userLeveFind;
      }
    }

    userLevelRepository.save(userLevel);

    return userLevel;
  }

  @Override
  public List<UserLevel> getTop20ResultByUserId(int userId) {
    List<UserLevel> userLevelList = userLevelRepository.findAllByUserId(userId);

    return userLevelList.stream()
        .sorted((o1, o2) -> Integer.compare(o2.getResult(), o1.getResult()))
        .limit(20)
        .collect(Collectors.toList());
  }

  @Override
  public List<UserLevel> getTop20UserByResult(int levelId) {
    List<UserLevel> userLevelList = userLevelRepository.findAllByLevelId(levelId);

    return userLevelList.stream()
        .sorted((o1, o2) -> Integer.compare(o2.getResult(), o1.getResult()))
        .limit(20)
        .collect(Collectors.toList());
  }

}
