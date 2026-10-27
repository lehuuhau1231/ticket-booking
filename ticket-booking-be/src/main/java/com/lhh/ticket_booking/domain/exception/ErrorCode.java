package com.lhh.ticket_booking.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", 500),
    USER_EXISTED(1001, "User already exists", 400),
    USER_NOT_FOUND(1002, "User not found", 404),
    INVALID_PASSWORD(1003, "Invalid password", 400),
    UNAUTHENTICATED(1004, "Unauthenticated", 401),
    UNAUTHORIZED(1005, "You do not have permission", 403);

    private final int code;
    private final String message;
    private final int httpStatusCode;

    ErrorCode(int code, String message, int httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
