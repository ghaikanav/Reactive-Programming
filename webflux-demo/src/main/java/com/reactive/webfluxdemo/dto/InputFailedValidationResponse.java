package com.reactive.webfluxdemo.dto;

import lombok.Data;

@Data
public class InputFailedValidationResponse {
    private Integer errorCode;
    private Integer input;
    private String message;
}
