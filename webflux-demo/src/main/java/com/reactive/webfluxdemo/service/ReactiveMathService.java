package com.reactive.webfluxdemo.service;

import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.util.SleepUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReactiveMathService {

    private static final Logger logger = LogManager.getLogger(ReactiveMathService.class);
    public Mono<Response> findSquare(Integer input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

    public Flux<Response> getMultiplicationTable(Integer input) {
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepForSeconds(1))
                .doOnNext(i -> logger.info("processing element: " + i))
                .map(i -> new Response(i * input));
    }
}
