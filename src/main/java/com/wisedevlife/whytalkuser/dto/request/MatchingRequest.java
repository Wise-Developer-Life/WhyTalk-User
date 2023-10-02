package com.wisedevlife.whytalkuser.dto.request;

import com.wisedevlife.whytalkuser.common.dto.RangePair;
import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import java.util.List;
import lombok.Getter;

@Getter
public class MatchingRequest {
    private String userId;
    private List<SexEnum> genderOptions;
    private RangePair<Integer> ageRange;
}
