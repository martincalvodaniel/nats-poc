package com.dmartinc.nats.poc.repositories.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class NatsPocDocument {

    @Id
    private ObjectId id;

    @Indexed
    private String traceId;

    @Indexed
    private Date creation;

    private String sentTo;
}
