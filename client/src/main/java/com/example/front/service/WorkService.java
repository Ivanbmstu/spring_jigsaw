package com.example.front.service;

import com.example.front.controller.RemoteClient;
import com.example.front.controller.dto.RemoteDataDTO;
import com.example.front.entity.BusinessData;
import com.example.front.repository.BusinessDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {
    private final RemoteClient remoteClient;
    private final BusinessDataRepository businessDataRepository;

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        RemoteDataDTO remoteDataDTO = remoteClient.callRemote(id);
        businessDataRepository.save(new BusinessData(UUID.randomUUID().toString(), remoteDataDTO.getBody(), remoteDataDTO.getServiceId()));
        log.info("saved new entity");
        return remoteDataDTO.getBody();
    }
}
