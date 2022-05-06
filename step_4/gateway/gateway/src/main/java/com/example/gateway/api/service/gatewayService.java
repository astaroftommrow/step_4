package com.example.gateway.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class gatewayService {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:9090/board/")
            .build();

}
