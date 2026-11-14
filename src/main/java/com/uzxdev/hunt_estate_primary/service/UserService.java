package com.uzxdev.hunt_estate_primary.service;

import com.uzxdev.hunt_estate_primary.document.User;
import com.uzxdev.hunt_estate_primary.document.UserAccountStatus;
import com.uzxdev.hunt_estate_primary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        log.info("Adding user {}", user.getUserName());
        user.setCreatedAt(Instant.now());
        user.setStatus(UserAccountStatus.CREATED);
        return userRepository.save(user);
    }


    public User findUserByUsername(String username) {
        log.info("Finding user by username {}", username);
        Optional<User> userOptional = userRepository.findByUserName(username);
        return userOptional.orElse(null);
    }
}
