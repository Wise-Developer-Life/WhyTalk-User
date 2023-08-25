package com.wisedevlife.whytalkuser.common.exception;

public class UserAlreadyExistedException extends IllegalArgumentException {
    public UserAlreadyExistedException(String key, String value) {
        super(String.format("USer with %s %s already existed", key, value));
    }
}
