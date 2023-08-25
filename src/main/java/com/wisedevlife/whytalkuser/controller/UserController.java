package com.wisedevlife.whytalkuser.controller;

import com.wisedevlife.whytalkuser.common.helper.ResponseHandler;
import com.wisedevlife.whytalkuser.dto.request.CreateUserRequest;
import com.wisedevlife.whytalkuser.dto.response.ReturnResponse;
import com.wisedevlife.whytalkuser.dto.response.UserResponse;
import com.wisedevlife.whytalkuser.entity.User;
import com.wisedevlife.whytalkuser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User API", description = "Register, delete users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Operation(summary = "Register new user with username/password")
    @PostMapping("/register")
    ResponseEntity<ReturnResponse<UserResponse>> registerNewUser(
            @RequestBody CreateUserRequest createUserRequest) {
        User registeredUser = userService.createUser(createUserRequest);
        UserResponse response = modelMapper.map(registeredUser, UserResponse.class);
        return ResponseHandler.success(response);
    }

    @Operation(summary = "Delete user with userId")
    @DeleteMapping("/{userId}")
    ResponseEntity<ReturnResponse<Void>> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseHandler.success();
    }
}
