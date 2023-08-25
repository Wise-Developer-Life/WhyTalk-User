package com.wisedevlife.whytalkuser.dto.response;

import lombok.Data;

@Data
public class UserProfileResponse {
    private Long userId;
    private String displayName;
    private String bio;
}
