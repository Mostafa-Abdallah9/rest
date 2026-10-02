package com.pioneers.rest.task.utils.validators;

@FunctionalInterface
public interface ValidatorService<T> {
    void validate(T t);
}
