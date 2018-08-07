package com.example.front.test;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Positive;

@Service
@Validated
public class WaitService {


    public Mono<String> loadSmth(@Positive Integer throttle, @Positive Integer id) {

        WebClient webClient = WebClient.builder().filter(logRequest()).baseUrl("http://localhost:8081").build();

        System.out.println("T " + throttle + " id " + id);

        return webClient.get().uri(uriBuilder -> uriBuilder.path("/throttle")
                .queryParam("throttle", throttle)
                .queryParam("id", id).build())
                .retrieve().bodyToMono(String.class);
    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> System.out.println(name + "=" + value)));
            return Mono.just(clientRequest);
        });
    }
}
