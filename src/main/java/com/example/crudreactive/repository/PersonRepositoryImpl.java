package com.example.crudreactive.repository;

import com.example.crudreactive.entity.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class PersonRepositoryImpl implements PersonRepository {
    private final ReactiveMongoRepository reactiveMongoRepository;
    public PersonRepositoryImpl(ReactiveMongoRepository reactiveMongoRepository) {
        this.reactiveMongoRepository = reactiveMongoRepository;
    }
    @Override
    public Flux<Person> findByAge(int age) {
        return reactiveMongoRepository.findAll().filter(person -> person.getAge() == age);
    }
    @Override
    public Flux<Person> findPersonOverAge(int age) {
        return reactiveMongoRepository.findAll().filter(person -> person.getAge() > age);
    }
    @Override
    public Flux<Person> findAllByLetterJ() {
        return reactiveMongoRepository
                .findAll()
                .filter(person -> person.getName().startsWith("J"));
    }


}
