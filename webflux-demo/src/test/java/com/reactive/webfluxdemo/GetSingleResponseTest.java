package com.reactive.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class GetSingleResponseTest extends BaseTest{

    @Autowired
    private WebClient webClient;
}
