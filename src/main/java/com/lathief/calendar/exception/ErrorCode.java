package com.lathief.calendar.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PASSWORD_NOT_MATCH("Password Mismatch"),
    ALREADY_EXISTS_USER("Account already exists"),
    USER_NOT_FOUND("Account does not exist"),
    VALIDATION_FAIL("The value is not valid"),
    BAD_REQUEST("Wrong Access"),
    EVENT_CREATE_OVERLAPPED_PERIOD("Overlapping event period");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
