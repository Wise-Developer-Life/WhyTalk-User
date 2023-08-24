package com.wisedevlife.whytalkuser.service.impl;

import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.service.UserProfileService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Override
    public UserProfile updateUserProfile(
            String userId, UpdateUserProfileRequest updateUserProfileRequest) {
        return null;
    }
}
