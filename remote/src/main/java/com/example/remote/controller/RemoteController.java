package com.example.remote.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class RemoteController {

    private final EurekaClient eurekaClient;

    @Autowired
    public RemoteController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping
    public String call(Integer id) {
        return eurekaClient.getApplicationInfoManager().getInfo().getInstanceId() + "processed with id " + id;
    }
}
