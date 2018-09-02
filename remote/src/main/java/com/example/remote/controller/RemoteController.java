package com.example.remote.controller;

import com.example.remote.controller.dto.RemoteDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class RemoteController {


    @GetMapping
    public RemoteDTO call(Integer id) {
        return new RemoteDTO("processed with id " + id, "remote");
    }

    @GetMapping(value = "xml", produces = MediaType.APPLICATION_XML_VALUE)
    public RemoteDTO callJaxb(Integer id)  {
        return new RemoteDTO("processed with id " + id, "remote");
    }
}
