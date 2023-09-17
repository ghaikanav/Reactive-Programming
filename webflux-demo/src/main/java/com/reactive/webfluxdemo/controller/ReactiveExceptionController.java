package com.reactive.webfluxdemo.controller;

import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.exception.InputValidationException;
import com.reactive.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveExceptionController {

    @Autowired
    ReactiveMathService mathService;
    @GetMapping("/square/{input}/throw")
    public Mono<Response> findSquare(@PathVariable Integer input) {
        if(input < 10 || input > 20){
            throw new InputValidationException(input);
        }
        return mathService.findSquare(input);
    }
}
