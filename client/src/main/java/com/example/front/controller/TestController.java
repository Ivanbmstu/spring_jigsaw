package com.example.front.controller;

import com.example.front.controller.dto.ResponseDTO;
import com.example.front.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Positive;

@RestController
@Validated
@RequiredArgsConstructor
public class TestController {

    private final WorkService workService;

    @GetMapping("/do-work")
    public Mono<ResponseDTO> loadRemoteCallResult(@Positive @RequestParam Integer id) {
        return workService.doWork(id).map(ResponseDTO::new);
    }


    @GetMapping(value = "/do-work-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<ResponseDTO> loadRemoteCallXmlResult(@Positive @RequestParam Integer id) {
        return workService.doWork(id).map(ResponseDTO::new);
    }
}
