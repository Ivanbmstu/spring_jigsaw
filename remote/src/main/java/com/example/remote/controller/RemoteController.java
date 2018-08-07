package com.example.remote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class RemoteController {
    
    @GetMapping
    public String call(Integer id) {
        return "processed with id " + id;
    }
}
