package com.pioneers.rest.amaan.errors.models;

import java.sql.Timestamp;
import java.util.Optional;

public record ErrorResponse<T>(int code, String message, String description, Timestamp timestamp, Optional<T> body) {
}
