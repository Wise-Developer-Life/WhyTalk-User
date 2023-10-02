package com.wisedevlife.whytalkuser.service;

import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.model.MatchingFilter;
import java.util.List;

public interface MatchingService {
    void startMatchingProcess(String userId, MatchingFilter filter);

    List<UserProfile> matchUser(String userId);
}
