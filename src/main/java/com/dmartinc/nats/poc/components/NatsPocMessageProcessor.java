package com.dmartinc.nats.poc.components;

import com.dmartinc.nats.poc.services.NatsPocService;
import io.nats.client.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NatsPocMessageProcessor {

    private final NatsPocService service;

    public void process(Message message) {
        log.info("Received message with SID={}", message.getSID());
        service.doStuff(new String(message.getData()));
    }
}
