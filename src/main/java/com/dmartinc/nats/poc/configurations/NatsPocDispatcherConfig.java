package com.dmartinc.nats.poc.configurations;

import com.dmartinc.nats.poc.components.NatsPocMessageProcessor;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class NatsPocDispatcherConfig {

    private final NatsPocPropertiesConfig properties;

    private final Connection connection;

    private final NatsPocMessageProcessor processor;

    @Bean
    Dispatcher messengerNatsStoreDispatcher() {
        Dispatcher dispatcher = connection.createDispatcher(processor::process);
        dispatcher.subscribe(properties.getSubscription(), properties.getQueue());
        return dispatcher;
    }
}
