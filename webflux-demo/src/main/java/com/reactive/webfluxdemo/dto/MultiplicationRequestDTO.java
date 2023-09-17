package com.reactive.webfluxdemo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MultiplicationRequestDTO {
    private Integer firstNumber;
    private Integer secondNumber;
}
