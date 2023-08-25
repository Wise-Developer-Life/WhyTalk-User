package com.wisedevlife.whytalkuser.common.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String key, Object value) {
        super(String.format("User with %s %s not found", key, value));
    }
}
