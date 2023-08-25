package com.wisedevlife.whytalkuser.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Basic Auth Request")
public record BasicAuthRequest(
        @Schema(description = "Username", example = "example_user", required = true)
        String username,
        @Schema(description = "Password", example = "example_password", required = true)
        String password
) {
}
