package com.wisedevlife.whytalkuser.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public record CreateProfileRequest(
        @JsonProperty("display_name") String displayName,
        @JsonProperty("birth_day") @DateTimeFormat(pattern = "yyyy-mm-dd") Date birthDay,
        @JsonProperty("gender") SexEnum sex) {}
