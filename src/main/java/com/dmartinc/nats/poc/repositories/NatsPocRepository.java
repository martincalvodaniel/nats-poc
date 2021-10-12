package com.dmartinc.nats.poc.repositories;

import com.dmartinc.nats.poc.repositories.model.NatsPocDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatsPocRepository extends MongoRepository<NatsPocDocument, String> {
}
