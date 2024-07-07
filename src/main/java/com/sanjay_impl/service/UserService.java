package com.sanjay_impl.service;

import com.sanjay_impl.entity.Product;
import com.sanjay_impl.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUser();

    void deleteUser(Long userId);

    User updateUserData(User user, Long userId);

    Map<String, List<User>> groupingByName();


}
