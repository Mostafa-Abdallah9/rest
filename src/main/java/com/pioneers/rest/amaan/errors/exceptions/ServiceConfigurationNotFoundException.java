package com.pioneers.rest.amaan.errors.exceptions;

import com.pioneers.rest.task.utils.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ServiceConfigurationNotFoundException extends RuntimeException {
    private final String description;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE = 6000;
    public static final String MESSAGE = "credentialsError";

    public ServiceConfigurationNotFoundException(final String description) {
        super(description);
        this.description = description;
    }
}
