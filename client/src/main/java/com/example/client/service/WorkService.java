package com.example.client.service;

import com.example.client.feign.RemoteClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.client.utils.JaxbUmarshall.unmarshall;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {

    private final RemoteClient remoteClient;

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        var monoRemoteJaxbDataDTO = unmarshall(remoteClient.getRawRemote(id));
        var monoRemoteDataDTO = remoteClient.getRemote(id);
        return monoRemoteDataDTO.getBody() + " " + monoRemoteJaxbDataDTO.getBody();
    }

}
