package com.mftplus.exception;

import org.jetbrains.annotations.NotNull;

public class AlreadyExistException extends Exception {
    public AlreadyExistException(@NotNull Object entity) {
        super(entity.getClass().getSimpleName() + " has already exist");
    }
}