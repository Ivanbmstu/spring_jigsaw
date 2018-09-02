package com.example.front.controller;

import com.example.front.service.WorkService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/do-work")
    public String loadRemoteCallResult(@Positive @RequestParam Integer id) {
        return workService.doWork(id);
    }

}
