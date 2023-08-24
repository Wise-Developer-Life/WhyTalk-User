package com.wisedevlife.whytalkuser.controller;

import com.wisedevlife.whytalkuser.dto.response.ReturnResponse;
import com.wisedevlife.whytalkuser.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Operation(summary = "Register new user with username/password")
    @PostMapping("/register")
    ResponseEntity<ReturnResponse<UserResponse>> registerNewUser() {
        return null;
    }

    @Operation(summary = "Delete user with userId")
    @DeleteMapping("/{userId}")
    ResponseEntity<ReturnResponse<UserResponse>> deleteUser(@PathVariable String userId) {
        return null;
    }
}
