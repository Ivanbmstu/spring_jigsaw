package com.example.front.service;

import com.example.front.controller.dto.RemoteDataDTO;
import com.example.front.util.JaxbUmarshall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
public class WorkService {
    private final WebClient webClient;

    public WorkService() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8092").build();
    }

    public Mono<String> doWork(Integer id) {
        log.info("calling work with id " + id);
        Mono<RemoteDataDTO> monoRemoteDataDTO = performGet("call", id, RemoteDataDTO.class);
        Mono<RemoteDataDTO> monoRemoteJaxbDataDTO = performGet("call/xml", id, String.class)
                .map(JaxbUmarshall::unmarshall);
        return Mono.zip(monoRemoteDataDTO,monoRemoteJaxbDataDTO, (left, right) -> left.getBody() + " " + right.getBody());
    }

    private <T> Mono<T> performGet(String uri, Integer id, Class<T> clazz) {
        return webClient.get()
                .uri(builder -> builder.path(uri).queryParam("id", id).build())
                .retrieve()
                .bodyToMono(clazz);

    }
}
