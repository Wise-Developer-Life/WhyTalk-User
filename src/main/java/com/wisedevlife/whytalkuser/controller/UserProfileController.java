package com.wisedevlife.whytalkuser.controller;

import com.wisedevlife.whytalkuser.dto.response.ReturnResponse;
import com.wisedevlife.whytalkuser.dto.response.UserProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_profile")
public class UserProfileController {
    @Operation(summary = "Get user profile with userId")
    @GetMapping("/{userId}")
    public ResponseEntity<ReturnResponse<UserProfileResponse>> getUserProfile(
            @PathVariable String userId) {
        return null;
    }

    @Operation(summary = "Update user profile with userId")
    @PutMapping("/{userId}")
    public ResponseEntity<ReturnResponse<UserProfileResponse>> updateUserProfile(
            @PathVariable String userId) {
        return null;
    }
}
