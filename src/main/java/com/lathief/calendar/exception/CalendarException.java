package com.lathief.calendar.exception;

public class CalendarException extends RuntimeException {
    private final ErrorCode errorCode;

    public CalendarException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}