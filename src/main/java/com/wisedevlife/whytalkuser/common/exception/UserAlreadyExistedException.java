package com.wisedevlife.whytalkuser.common.exception;

public class UserAlreadyExistedException extends IllegalArgumentException {
    public UserAlreadyExistedException(String key, String value) {
        super(String.format("User with %s %s already existed", key, value));
    }
}
