package com.example.front.controller;

import com.example.front.controller.dto.RemoteDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="remote")
public interface RemoteJaxbClient {

    @GetMapping(value = "/call/xml")
    String callRemote(@RequestParam("id") Integer id);
}
