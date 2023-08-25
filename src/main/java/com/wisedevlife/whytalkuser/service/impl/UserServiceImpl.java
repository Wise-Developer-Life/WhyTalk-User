package com.wisedevlife.whytalkuser.service.impl;

import com.wisedevlife.whytalkuser.common.exception.UserAlreadyExistedException;
import com.wisedevlife.whytalkuser.common.exception.UserNotFoundException;
import com.wisedevlife.whytalkuser.dto.request.CreateUserRequest;
import com.wisedevlife.whytalkuser.entity.User;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.repository.UserRepository;
import com.wisedevlife.whytalkuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByUsername(createUserRequest.username())) {
            throw new UserAlreadyExistedException("username", createUserRequest.username());
        }

        if (userRepository.existsByEmail(createUserRequest.email())) {
            throw new UserAlreadyExistedException("email", createUserRequest.email());
        }

        String hashedPassword = passwordEncoder.encode(createUserRequest.password());
        UserProfile userProfile = UserProfile.builder().sex(createUserRequest.sex()).build();
        User createdUser =
                User.builder()
                        .userProfile(userProfile)
                        .username(createUserRequest.username())
                        .password(hashedPassword)
                        .email(createUserRequest.email())
                        .build();

        return userRepository.save(createdUser);
    }

    @Override
    public User getUserWithUserId(Long userId) {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new UserNotFoundException("userId", userId));
        return user;
    }

    @Override
    public Boolean matchUsernamePassword(String username, String password) {
        return userRepository.findByUsername(username).filter(user -> passwordEncoder.matches(password, user.getPassword())).isPresent();
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("userId", userId);
        }

        userRepository.deleteById(userId);
    }
}
