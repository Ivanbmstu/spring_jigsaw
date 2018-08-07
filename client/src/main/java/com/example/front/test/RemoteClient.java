package com.example.front.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="remote", url = "http://localhost:8091")
public interface RemoteClient {
    
    @GetMapping("/call")
    String callRemote(@RequestParam("id") Integer id);
}
