package com.wisedevlife.whytalkuser.entity;

import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfile {
    @Id private String userId;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private String displayName;

    private Date birthDay;
}
