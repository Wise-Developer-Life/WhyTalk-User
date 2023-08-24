package com.wisedevlife.whytalkuser.service.impl;

import com.wisedevlife.whytalkuser.dto.request.CreateUserRequest;
import com.wisedevlife.whytalkuser.entity.User;
import com.wisedevlife.whytalkuser.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public User getUserWithUserId(String userId) {
        return null;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }
}
