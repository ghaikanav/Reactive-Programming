package com.reactive.webfluxdemo.service;

import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.util.SleepUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    private static final Logger logger = LogManager.getLogger(MathService.class);
    public Response findSquare(Integer input) {
        return new Response(input * input);
    }

    /**
     * Generates a multiplication table for a given integer.
     * This method calculates the product of the input integer with numbers from 1 to 10,
     * with a one-second delay between each calculation. It also prints a log message
     * indicating the processing of each element.
     *
     * @param input The integer for which the multiplication table is generated.
     * @return A list of Response objects, each containing the result of the multiplication.
     */
    public List<Response> getMultiplicationTable(Integer input) {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> SleepUtil.sleepForMilliseconds(200))
                .peek(i -> logger.info("processing element : " + i))
                .mapToObj(i -> new Response(input * i))
                .collect(Collectors.toList());
    }
}
