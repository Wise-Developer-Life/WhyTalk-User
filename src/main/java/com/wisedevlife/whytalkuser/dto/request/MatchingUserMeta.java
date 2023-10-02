package com.wisedevlife.whytalkuser.dto.request;

import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.model.MatchingFilter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatchingUserMeta {
    UserProfile userProfile;
    MatchingFilter matchingFilter;
    long startMatchingTimestamp;
}
