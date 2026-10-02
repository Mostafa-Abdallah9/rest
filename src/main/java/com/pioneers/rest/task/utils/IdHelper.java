package com.pioneers.rest.task.utils;

import java.util.UUID;

public final class IdHelper {

    private IdHelper() {
        throw new AssertionError("Utility Class");
    }

    public static UUID randomUuidV4() {
        return UUID.randomUUID();
    }
}
