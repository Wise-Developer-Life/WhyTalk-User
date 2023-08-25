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
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByUsername(createUserRequest.username())) {
            throw new UserAlreadyExistedException("username", createUserRequest.username());
        }

        if (userRepository.existsByEmail(createUserRequest.email())) {
            throw new UserAlreadyExistedException("email", createUserRequest.email());
        }

        // hash password
        UserProfile userProfile = UserProfile.builder().sex(createUserRequest.sex()).build();
        User createdUser =
                User.builder()
                        .userProfile(userProfile)
                        .username(createUserRequest.username())
                        .password(createUserRequest.password())
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
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("userId", userId);
        }

        userRepository.deleteById(userId);
    }
}
