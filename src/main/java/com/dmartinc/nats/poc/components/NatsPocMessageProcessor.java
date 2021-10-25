package com.dmartinc.nats.poc.components;

import com.dmartinc.nats.poc.services.NatsPocService;
import io.nats.client.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Slf4j
@EnableAsync
@RequiredArgsConstructor
@Component
public class NatsPocMessageProcessor {

    private final NatsPocService service;

    @Async
    public void process(Message message) {
        log.info("Received message with subject={}", message.getSubject());
        service.doStuff(new String(message.getData()));
    }
}
