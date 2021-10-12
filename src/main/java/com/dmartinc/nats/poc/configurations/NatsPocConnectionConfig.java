package com.dmartinc.nats.poc.configurations;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class NatsPocConnectionConfig {

    private final NatsPocPropertiesConfig natsPocPropertiesConfig;

    @Bean
    Connection connection() throws IOException, InterruptedException {
        return Nats.connect(natsConnectionOptions());
    }

    private Options natsConnectionOptions() {
        return new Options.Builder()
                .server(natsPocPropertiesConfig.getServer())
                .maxReconnects(-1)
                .connectionName(getClass().getSimpleName())
                .build();
    }
}
