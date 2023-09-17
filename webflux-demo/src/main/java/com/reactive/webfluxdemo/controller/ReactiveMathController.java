package com.reactive.webfluxdemo.controller;

import com.reactive.webfluxdemo.dto.MultiplicationRequestDTO;
import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;


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

    @PostMapping("/multiply")
    public Mono<Response> getProduct(@RequestBody Mono<MultiplicationRequestDTO> requestDTOMono,
                                     @RequestHeader Map<String, String> headers) {
        System.out.println(headers);
        return mathService.getProduct(requestDTOMono);
    }

    @GetMapping("/cube/{input}/assignment")
    public Mono<ResponseEntity<Response>> getCube(@PathVariable Integer input) {
        if (input < 10 || input > 20) {
            return Mono.just(ResponseEntity.badRequest().build());
        }
        return mathService.findCube(input).map(ResponseEntity::ok);
    }

    @GetMapping("/cube/{input}/solution")
    public Mono<ResponseEntity<Response>> getCubeSolution(@PathVariable Integer input) {
        return Mono.just(input)
                .filter(i -> i > 10 && i < 20)
                .flatMap(i -> mathService.findCube(i))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
