package com.dmartinc.nats.poc.components;

import com.dmartinc.nats.poc.services.NatsPocService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@EnableScheduling
@Component
public class NatsPocScheduler {

    private final NatsPocService service;

    @Scheduled(fixedRate = 5_000)
    public void exec() {
        String traceId = UUID.randomUUID().toString();
        service.doStuff(traceId);
    }
}
