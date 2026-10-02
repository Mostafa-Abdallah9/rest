package com.pioneers.rest.function_programming.nn;

@FunctionalInterface
public interface ValidatorService<T> {

    void validate(T t);
}
