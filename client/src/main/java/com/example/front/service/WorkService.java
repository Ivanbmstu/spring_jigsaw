package com.example.front.service;

import com.example.front.client.RemoteClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.front.util.JaxbUmarshall.unmarshall;

@Service
@Slf4j
public class WorkService {
    private RestTemplate restTemplate;

    @Autowired
    private RemoteClient remoteClient;

    @Value("${remote.port:8092}")
    private String remotePort;

    public WorkService() {
        this.restTemplate = new RestTemplate();
    }

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        var monoRemoteJaxbDataDTO = unmarshall(remoteClient.getRawRemote(id));
        var monoRemoteDataDTO = remoteClient.getRemote(id);
        return monoRemoteDataDTO.getBody() + " " + monoRemoteJaxbDataDTO.getBody();
    }

}
