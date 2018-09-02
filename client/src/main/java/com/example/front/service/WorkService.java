package com.example.front.service;

import com.example.front.controller.dto.RemoteDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.front.util.JaxbUmarshall.unmarshall;

@Service
@Slf4j
public class WorkService {
    private RestTemplate restTemplate;

    public WorkService() {
        this.restTemplate = new RestTemplate();
    }

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        final String remoteHost = "http://localhost:8092";
        var monoRemoteDataDTO = restTemplate.getForObject(remoteHost + "/call?id=" + id, RemoteDataDTO.class);
        var monoRemoteJaxbDataDTO = unmarshall(restTemplate.getForObject(remoteHost + "/call/xml?id=" + id,
                String.class));
        return monoRemoteDataDTO.getBody() + " " + monoRemoteJaxbDataDTO.getBody();
    }

}
