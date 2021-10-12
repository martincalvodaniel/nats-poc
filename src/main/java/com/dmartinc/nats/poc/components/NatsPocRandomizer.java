package com.dmartinc.nats.poc.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Component
public class NatsPocRandomizer {

    public boolean randomBool() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public <T> T randomItemFromList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
}
