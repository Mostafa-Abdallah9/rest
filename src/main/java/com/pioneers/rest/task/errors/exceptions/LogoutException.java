package com.pioneers.rest.task.errors.exceptions;

import com.pioneers.rest.task.utils.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;

@Getter
@EqualsAndHashCode(callSuper = false)
public class LogoutException extends RuntimeException {
    private final String description;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE = 4000;
    public static final String MESSAGE = "logoutError";

    public LogoutException(String description) {
        super(description);

        this.description = description;
    }
}
