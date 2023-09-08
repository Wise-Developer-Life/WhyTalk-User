package com.wisedevlife.whytalkuser.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserProfileResponse {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @JsonProperty("gender")
    private SexEnum sex;
}
