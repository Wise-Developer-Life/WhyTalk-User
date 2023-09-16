package com.wisedevlife.whytalkuser.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import com.wisedevlife.whytalkuser.common.utils.UserProfileUtil;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
public class UserProfileResponse {
    public static UserProfileResponse of(UserProfile userProfile) {
        UserProfileUtil profileUtil = UserProfileUtil.builder().build();
        Integer userAge = profileUtil.convertBirthDayToAge(userProfile.getBirthDay());
        return UserProfileResponse.builder()
                .userId(userProfile.getUserId())
                .sex(userProfile.getSex())
                .displayName(userProfile.getDisplayName())
                .birthDay(userProfile.getBirthDay())
                .age(userAge)
                .build();
    }

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private SexEnum sex;
}
