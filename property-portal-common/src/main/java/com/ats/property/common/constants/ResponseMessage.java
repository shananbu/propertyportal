package com.ats.property.common.constants;

/**
 * The ResponseMessage.
 *
 * @author anbarasan.s
 */
public enum ResponseMessage {
    SUCCESSFUL_RESPONSE(100, "Successful"),
    INVALID_CREDENTIALS(101, "Invalid Username/Password"),
    AUTH_REQUIRED(102, "Authentication Required"),
    UNEXPECTED_ERROR(103, "Unexpected Error"),
    INVALID_SESSION(104, "Invalid Session"),
    USER_EXISTS(105, "User Already Exists!"),
    INVALID_USER(106, "Invalid User. Please try with correct user!"),
    INVALID_REQUEST(104, "Invalid Request. The token may be expired!"),
    ;

    private final int code;

    private final String message;

    private ResponseMessage(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
