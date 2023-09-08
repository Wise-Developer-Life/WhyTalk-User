package com.wisedevlife.whytalkuser.service;

import com.wisedevlife.whytalkuser.dto.request.CreateProfileRequest;
import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.entity.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile(String userId, CreateProfileRequest createProfileRequest);

    UserProfile getUserProfile(String userId);

    UserProfile updateUserProfile(String userId, UpdateUserProfileRequest updateUserProfileRequest);
}
