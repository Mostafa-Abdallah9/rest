package com.pioneers.rest.function_programming.nn;

import java.sql.Timestamp;

public record GenericResponse<T>(int code, Timestamp timestamp, T body) {
}
