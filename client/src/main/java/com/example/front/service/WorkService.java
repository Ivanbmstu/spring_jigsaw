package com.example.front.service;

import com.example.front.controller.RemoteClient;
import com.example.front.controller.dto.RemoteDataDTO;
import com.example.front.entity.RemoteData;
import com.example.front.repository.RemoteDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {
    private final RemoteClient remoteClient;
    private final RemoteDataRepository remoteDataRepository;

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        RemoteDataDTO remoteDataDTO = remoteClient.callRemote(id);
        remoteDataRepository.save(new RemoteData(UUID.randomUUID().toString(), remoteDataDTO.getBody(), remoteDataDTO.getServiceId()));
        log.info("saved new entity");
        return remoteDataDTO.getBody();
    }
}
