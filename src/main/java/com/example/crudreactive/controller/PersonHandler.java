package com.example.crudreactive.controller;

import com.example.crudreactive.entity.Person;
import com.example.crudreactive.repository.PersonRepository;
import com.example.crudreactive.repository.ReactiveMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

    @Autowired
    ReactiveMongoRepository repository;
    @Autowired
    PersonRepository personRepository;

    public Mono<ServerResponse> savePerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        return ServerResponse.ok().body(BodyInserters.fromPublisher(repository.saveAll(person), Person.class));
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromPublisher(repository.findAll(), Person.class));
    }

    public Mono<ServerResponse> getPersonByAge(ServerRequest request) {
        int age = Integer.parseInt(request.pathVariable("age"));
        return ServerResponse.ok().body(BodyInserters.fromPublisher(personRepository.findByAge(age), Person.class));
    }

    public Mono<ServerResponse> getPersonsByLetterJ(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromPublisher(personRepository.findAllByLetterJ(), Person.class));
    }
}
