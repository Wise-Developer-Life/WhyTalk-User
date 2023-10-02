package com.wisedevlife.whytalkuser.common.utils;

import java.time.LocalDate;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class UserProfileUtil {
    public int convertBirthDayToAge(LocalDate birthDay) {
        return LocalDate.now().getYear() - birthDay.getYear();
    }
}
