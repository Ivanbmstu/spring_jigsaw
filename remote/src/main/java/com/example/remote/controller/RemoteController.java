package com.example.remote.controller;

import com.example.remote.controller.dto.RemoteDTO;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/call")
public class RemoteController {

    private final EurekaClient eurekaClient;

    @Autowired
    public RemoteController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping
    public RemoteDTO call(Integer id) {
        return new RemoteDTO("processed with id " + id, eurekaClient.getApplicationInfoManager().getInfo().getInstanceId());
    }

    @GetMapping(value = "xml", produces = MediaType.APPLICATION_XML_VALUE)
    public RemoteDTO callJaxb(Integer id)  {
        return new RemoteDTO("processed with id " + id, eurekaClient.getApplicationInfoManager().getInfo().getInstanceId());
    }
}
