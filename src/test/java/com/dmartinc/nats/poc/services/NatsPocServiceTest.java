package com.dmartinc.nats.poc.services;

import com.dmartinc.nats.poc.components.NatsPocRandomizer;
import com.dmartinc.nats.poc.configurations.NatsPocPropertiesConfig;
import com.dmartinc.nats.poc.repositories.NatsPocRepository;
import io.nats.client.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NatsPocServiceTest {

    private static final String TRACE_ID = UUID.randomUUID().toString();

    private NatsPocService service;

    @Mock
    private NatsPocPropertiesConfig properties;

    @Mock
    private Connection connection;

    @Mock
    private NatsPocRepository repository;

    @Mock
    private NatsPocRandomizer randomizer;

    @BeforeEach
    void beforeEach() {
        service = new NatsPocService(properties, connection, repository, randomizer);
    }

    @Test
    void doStuffShouldCallRepositoryToStore() {
        service.doStuff(TRACE_ID);
        verify(repository, times(1)).save(any());
    }

    @Test
    void doStuffShouldNotPublishWhenRandomizerReturnsFalse() {
        service.doStuff(TRACE_ID);
        verify(connection, times(0)).publish(any(), any());
    }

    @Test
    void doStuffShouldPublishWhenRandomizerReturnsTrue() {
        when(randomizer.randomBool()).thenReturn(Boolean.TRUE);
        service.doStuff(TRACE_ID);
        verify(connection, times(1)).publish(any(), any());
    }
}