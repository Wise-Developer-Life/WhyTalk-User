package com.wisedevlife.whytalkuser.dto.message;

import com.wisedevlife.whytalkuser.dto.response.UserProfileResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatchedUsersMessage {
    private UserProfileResponse user1;
    private UserProfileResponse user2;
}
