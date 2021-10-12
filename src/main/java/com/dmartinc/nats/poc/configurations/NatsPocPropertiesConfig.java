package com.dmartinc.nats.poc.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.dmartinc.nats.poc")
public class NatsPocPropertiesConfig {

    private String server;

    private String subscription;

    private String queue;

    private List<String> topics;

}
