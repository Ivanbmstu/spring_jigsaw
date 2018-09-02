package com.example.front.controller;

import com.example.front.controller.dto.ResponseDTO;
import com.example.front.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@Validated
@RequiredArgsConstructor
public class TestController {

    private final WorkService workService;

    @GetMapping(value = "/do-work")
    public ResponseDTO loadRemoteCallResult(@Positive @RequestParam Integer id) {
        return new ResponseDTO(workService.doWork(id));
    }


    @GetMapping(value = "/do-work-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseDTO loadRemoteCallXmlResult(@Positive @RequestParam Integer id) {
        return new ResponseDTO(workService.doWork(id));
    }
}
