package com.dmartinc.nats.poc.services;

import com.dmartinc.nats.poc.components.NatsPocRandomizer;
import com.dmartinc.nats.poc.configurations.NatsPocPropertiesConfig;
import com.dmartinc.nats.poc.repositories.NatsPocRepository;
import com.dmartinc.nats.poc.repositories.model.NatsPocDocument;
import io.nats.client.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class NatsPocService {

    private final NatsPocPropertiesConfig properties;

    private final Connection connection;

    private final NatsPocRepository repository;

    private final NatsPocRandomizer randomizer;

    public void doStuff(String traceId) {
        log.info("Doing stuff for {}", traceId);
        String topic = null;
        if (randomizer.randomBool()) {
            topic = randomizer.randomItemFromList(properties.getTopics());
            log.info("Publishing {} for {}", traceId, topic);
            connection.publish(topic, traceId.getBytes(StandardCharsets.UTF_8));
        }
        repository.save(buildNatsPocDocument(traceId, topic));
    }

    private NatsPocDocument buildNatsPocDocument(String traceId, String topic) {
        NatsPocDocument ret = new NatsPocDocument();
        ret.setTraceId(traceId);
        ret.setSentTo(topic);
        ret.setCreation(new Date());
        return ret;
    }
}
