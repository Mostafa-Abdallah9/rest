package com.pioneers.rest.success;

@FunctionalInterface
public interface Any<A,B,C> {
        C apply(A a,B b);
}
