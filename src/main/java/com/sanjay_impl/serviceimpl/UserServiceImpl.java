package com.sanjay_impl.serviceimpl;


import com.sanjay_impl.entity.Product;
import com.sanjay_impl.entity.User;
import com.sanjay_impl.repository.ProductRepository;
import com.sanjay_impl.repository.UserRepository;
import com.sanjay_impl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   private ProductRepository productRepository;
    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();

        return userList;
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        userRepository.delete(user);

    }

    @Override
    public User updateUserData(User user, Long userId) {
        User updateUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        updateUser.setName(user.getName());
        updateUser.setAbout(user.getAbout());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());

        return updateUser;
    }

    @Override
    public Map<String, List<User>> groupingByName() {
        List<User> users = userRepository.findAll();
        return users.stream().collect(Collectors.groupingBy(User::getName));
    }


}
