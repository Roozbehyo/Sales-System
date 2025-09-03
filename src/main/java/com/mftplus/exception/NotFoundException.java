package com.mftplus.exception;

import org.jetbrains.annotations.NotNull;

public class NotFoundException extends Exception {
    public NotFoundException(@NotNull Object entity) {
        super(entity.getClass().getSimpleName() + " Not Found");
    }
}
