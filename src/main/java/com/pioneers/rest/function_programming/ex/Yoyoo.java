package com.pioneers.rest.function_programming.ex;
@FunctionalInterface
public interface Yoyoo<T,R> {
    T apply(T t, R r);
}
