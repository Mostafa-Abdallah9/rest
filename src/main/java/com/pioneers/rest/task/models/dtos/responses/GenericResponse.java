package com.pioneers.rest.task.models.dtos.responses;

public record GenericResponse<T>(String message, T body) {
}
