package com.wisedevlife.whytalkuser.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Update User Profile Request")
public record UpdateUserProfileRequest(
        @Schema(example = "example_display_name") String displayName,
        @Schema(example = "example_bio") String bio) {}
