package com.sanjay_impl.config;

import com.sanjay_impl.entity.User;
import com.sanjay_impl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> email = userRepository.findByEmail(username);
        return email.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("user not found" + username));

    }
}
