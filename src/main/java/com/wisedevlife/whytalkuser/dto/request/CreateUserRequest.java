package com.wisedevlife.whytalkuser.dto.request;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Create User Request")
public record CreateUserRequest(
        @Schema(requiredMode = REQUIRED, example = "example_user") String username,
        @Schema(requiredMode = REQUIRED, example = "example@gmail.com") String email,
        @Schema(example = "example_password") String password,
        @Schema(requiredMode = REQUIRED, example = "MALE") SexEnum sex) {}
