package com.wisedevlife.whytalkuser.common.utils;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUtil {
    public int convertBirthDayToAge(LocalDate birthDay) {
        return LocalDate.now().getYear() - birthDay.getYear();
    }
}
