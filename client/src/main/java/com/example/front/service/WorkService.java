package com.example.front.service;

import com.example.front.client.RemoteClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.front.utils.JaxbUmarshall.unmarshall;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {

    private final RemoteClient remoteClient;

    @Value("${remote.port:8092}")
    private String remotePort;


    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        var monoRemoteJaxbDataDTO = unmarshall(remoteClient.getRawRemote(id));
        var monoRemoteDataDTO = remoteClient.getRemote(id);
        return monoRemoteDataDTO.getBody() + " " + monoRemoteJaxbDataDTO.getBody();
    }

}
