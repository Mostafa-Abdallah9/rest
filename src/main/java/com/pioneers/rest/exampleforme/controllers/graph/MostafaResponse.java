package com.pioneers.rest.exampleforme.controllers.graph;

import java.sql.Timestamp;
import java.util.Optional;

public record MostafaResponse<T>(int code, String message, String description, Timestamp timestamp, Optional<T> body) {

}
