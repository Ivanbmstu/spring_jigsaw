package com.example.client.feign;

import com.example.client.controller.dto.RemoteDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "remote", url = "http://localhost:${remote.port:8092}")
public interface RemoteClient {


    @GetMapping("call")
    RemoteDataDTO getRemote(@RequestParam("id") Integer id);
    @GetMapping("call/xml")
    String getRawRemote(@RequestParam("id") Integer id);
}
