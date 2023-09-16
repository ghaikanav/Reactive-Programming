package com.reactive.webfluxdemo.controller;

import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("reactive-math")
public class ReactiveMathController {
    @Autowired
    ReactiveMathService mathService;

    @GetMapping("/square/{input}")
    public Mono<Response> findSquare(@PathVariable Integer input) {
        return mathService.findSquare(input);
    }

    @GetMapping("/table/{input}")
    public Flux<Response> getTable(@PathVariable Integer input) {
        return mathService.getMultiplicationTable(input);
    }

    @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> getTableStream(@PathVariable Integer input) {
        return mathService.getMultiplicationTable(input);
    }
}
