package com.wisedevlife.whytalkuser.service.implement;

import com.wisedevlife.whytalkuser.common.exception.UserAlreadyExistedException;
import com.wisedevlife.whytalkuser.common.exception.UserNotFoundException;
import com.wisedevlife.whytalkuser.dto.request.CreateProfileRequest;
import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.repository.UserProfileRepository;
import com.wisedevlife.whytalkuser.service.UserProfileService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Primary
@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createUserProfile(String userId, CreateProfileRequest createProfileRequest) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUserId(userId);
        if (userProfile.isPresent()) {
            throw new UserAlreadyExistedException("userId", userId);
        }

        UserProfile profile =
                UserProfile.builder()
                        .userId(userId)
                        .sex(createProfileRequest.sex())
                        .birthDay(createProfileRequest.birthDay())
                        .displayName(createProfileRequest.displayName())
                        .build();

        return userProfileRepository.save(profile);
    }

    @Override
    public UserProfile getUserProfile(String userId) {
        return userProfileRepository
                .findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("userId", userId));
    }

    @Override
    public UserProfile updateUserProfile(
            String userId, UpdateUserProfileRequest updateUserProfileRequest) {
        UserProfile userProfile =
                userProfileRepository
                        .findByUserId(userId)
                        .orElseThrow(() -> new UserNotFoundException("userId", userId));

        if (updateUserProfileRequest.displayName() != null) {
            userProfile.setDisplayName(updateUserProfileRequest.displayName());
        }

        return userProfileRepository.save(userProfile);
    }
}
