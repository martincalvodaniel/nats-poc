package com.dmartinc.nats.poc.components;

import com.dmartinc.nats.poc.services.NatsPocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NatsPocSchedulerTest {

    private NatsPocScheduler scheduler;

    @Mock
    private NatsPocService service;


    @BeforeEach
    void beforeEach() {
        scheduler = new NatsPocScheduler(service);
    }

    @Test
    void shouldDoStuffAtServiceWhenExec() {
        scheduler.exec();
        verify(service, times(1)).doStuff(any());
    }
}