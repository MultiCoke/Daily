package com.itheima.exception;

public class AgeOutOfRangeException extends Exception {
    public AgeOutOfRangeException() {
    }

    public AgeOutOfRangeException(String message) {
        super(message);
    }
}
