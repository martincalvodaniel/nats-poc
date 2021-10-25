package com.dmartinc.nats.poc.components;

import com.dmartinc.nats.poc.services.NatsPocService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

import static com.dmartinc.nats.poc.common.NatsPocPropertyKeys.SCHEDULE_RATE_KEY;

@Slf4j
@ConditionalOnProperty(SCHEDULE_RATE_KEY)
@RequiredArgsConstructor
@EnableScheduling
@Component
public class NatsPocScheduler {

    private final NatsPocService service;

    @PostConstruct
    public void postConstruct() {
        log.info("Enabled");
    }

    @Scheduled(fixedRateString = "${" + SCHEDULE_RATE_KEY + "}", initialDelay = 5_000)
    public void exec() {
        service.doStuff(UUID.randomUUID().toString());
    }
}
