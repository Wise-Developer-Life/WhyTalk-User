package com.wisedevlife.whytalkuser.entity;

import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String displayName;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private String bio;
}
