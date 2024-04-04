package com.example.crudreactive.repository;

import com.example.crudreactive.entity.Person;
import reactor.core.publisher.Flux;

public interface PersonRepository {
    Flux<Person> findByAge(int age);
    Flux<Person> findPersonOverAge(int age);
    Flux<Person> findAllByLetterJ();
}
