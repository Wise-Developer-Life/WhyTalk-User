package com.wisedevlife.whytalkuser.service;

import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.entity.UserProfile;

public interface UserProfileService {
    UserProfile getUserProfile(Long userId);

    UserProfile updateUserProfile(Long userId, UpdateUserProfileRequest updateUserProfileRequest);
}
