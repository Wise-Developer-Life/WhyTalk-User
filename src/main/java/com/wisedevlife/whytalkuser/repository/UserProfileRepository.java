package com.wisedevlife.whytalkuser.repository;

import com.wisedevlife.whytalkuser.entity.UserProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
    Optional<UserProfile> findByUserId(String userEmail);
}
