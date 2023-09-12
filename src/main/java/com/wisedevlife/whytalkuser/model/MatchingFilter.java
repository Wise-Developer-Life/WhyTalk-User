package com.wisedevlife.whytalkuser.model;

import com.wisedevlife.whytalkuser.common.enums.SexEnum;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Range;

@Data
@Builder
public class MatchingFilter {
    private Range<Integer> ageRange;
    private List<SexEnum> genderOptions;
}
