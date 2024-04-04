package com.example.crudreactive.repository;

import com.example.crudreactive.entity.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReactiveMongoRepository extends ReactiveCrudRepository<Person, String> {
}
