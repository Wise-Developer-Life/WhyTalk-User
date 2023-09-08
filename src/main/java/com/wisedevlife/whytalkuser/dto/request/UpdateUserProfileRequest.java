package com.wisedevlife.whytalkuser.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Update User Profile Request")
public record UpdateUserProfileRequest(
        @JsonProperty("display_name") @Schema(example = "Gilbert Wang") String displayName) {}
