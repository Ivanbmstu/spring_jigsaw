package com.example.front.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Positive;

@RestController
@Validated
@RequiredArgsConstructor
public class FluxTestController {

    private final RemoteClient remoteClient;

    @GetMapping("/do-work")
    public String loadRemoteCallResult(@Positive @RequestParam Integer id) {
        return remoteClient.callRemote(id);
    }
    

}
