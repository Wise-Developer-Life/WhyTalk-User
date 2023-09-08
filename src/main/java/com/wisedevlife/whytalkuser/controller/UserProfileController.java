package com.wisedevlife.whytalkuser.controller;

import com.wisedevlife.whytalkuser.common.helper.ResponseHandler;
import com.wisedevlife.whytalkuser.dto.request.CreateProfileRequest;
import com.wisedevlife.whytalkuser.dto.request.UpdateUserProfileRequest;
import com.wisedevlife.whytalkuser.dto.response.ReturnResponse;
import com.wisedevlife.whytalkuser.dto.response.UserProfileResponse;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_profile")
@RequiredArgsConstructor
@Tag(name = "User Profile API", description = "Get, update user profile")
public class UserProfileController {

    private final ModelMapper modelMapper;
    private final UserProfileService userProfileService;

    @Operation(summary = "Create user profile with userId")
    @PostMapping("/{userId}")
    public ResponseEntity<ReturnResponse<UserProfileResponse>> createUserProfile(
            @PathVariable String userId, @RequestBody CreateProfileRequest createProfileRequest) {
        UserProfile userProfile =
                userProfileService.createUserProfile(userId, createProfileRequest);
        UserProfileResponse response = modelMapper.map(userProfile, UserProfileResponse.class);
        return ResponseHandler.success(response);
    }

    @Operation(summary = "Get user profile with userId")
    @GetMapping("/{userId}")
    public ResponseEntity<ReturnResponse<UserProfileResponse>> getUserProfile(
            @PathVariable String userId) {
        UserProfile userProfile = userProfileService.getUserProfile(userId);
        UserProfileResponse response = modelMapper.map(userProfile, UserProfileResponse.class);
        return ResponseHandler.success(response);
    }

    @Operation(summary = "Update user profile with userId")
    @PutMapping("/{userId}")
    public ResponseEntity<ReturnResponse<UserProfileResponse>> updateUserProfile(
            @PathVariable String userId, @RequestBody UpdateUserProfileRequest userProfileRequest) {
        UserProfile updatedProfile =
                userProfileService.updateUserProfile(userId, userProfileRequest);
        UserProfileResponse response = modelMapper.map(updatedProfile, UserProfileResponse.class);
        return ResponseHandler.success(response);
    }
}
