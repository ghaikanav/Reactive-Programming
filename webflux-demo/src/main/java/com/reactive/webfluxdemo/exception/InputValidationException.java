package com.reactive.webfluxdemo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InputValidationException extends RuntimeException {
    private static final String MESSAGE = "Input should be between 10 and 20";
    private final Integer errorCode = 101;

    private final Integer input;


    public InputValidationException(Integer input) {
        super(MESSAGE);
        this.input = input;
    }
}
