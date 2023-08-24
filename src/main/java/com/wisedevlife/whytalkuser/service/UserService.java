package com.wisedevlife.whytalkuser.service;

import com.wisedevlife.whytalkuser.dto.request.CreateUserRequest;
import com.wisedevlife.whytalkuser.entity.User;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest);

    User getUserWithUserId(final String userId);

    User deleteUser(final String userId);
}