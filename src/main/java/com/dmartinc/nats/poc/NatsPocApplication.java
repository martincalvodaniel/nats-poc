package com.dmartinc.nats.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.dmartinc.nats.poc")
public class NatsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(NatsPocApplication.class, args);
    }

}
