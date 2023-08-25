package com.wisedevlife.whytalkuser.service.impl;

import com.wisedevlife.whytalkuser.common.exception.UserNotFoundException;
import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.entity.User;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.repository.UserRepository;
import com.wisedevlife.whytalkuser.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserRepository userRepository;

    @Override
    public UserProfile getUserProfile(Long userId) {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new UserNotFoundException("userId", userId));
        return user.getUserProfile();
    }

    @Override
    public UserProfile updateUserProfile(
            Long userId, UpdateUserProfileRequest updateUserProfileRequest) {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new UserNotFoundException("userId", userId));
        UserProfile profile = user.getUserProfile();

        if (updateUserProfileRequest.bio() != null) {
            profile.setBio(updateUserProfileRequest.bio());
        }

        if (updateUserProfileRequest.displayName() != null) {
            profile.setDisplayName(updateUserProfileRequest.displayName());
        }

        UserProfile updatedProfile = userRepository.save(user).getUserProfile();

        return updatedProfile;
    }
}
