package com.example.crudreactive;

import com.example.crudreactive.entity.Person;
import com.example.crudreactive.repository.PersonRepository;
import com.example.crudreactive.repository.ReactiveMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ReactiveMongoRepository reactiveMongoRepository, PersonRepository personRepository){
        return args -> {
            Flux.just(
                    new Person(null, "Alice", 23),
                    new Person(null, "Bob", 38),
                    new Person(null, "Charlie", 28),
                    new Person(null, "David", 19),
                    new Person(null, "Eve", 24),
                    new Person(null, "Frank", 33),
                    new Person(null, "Tom", 33),
                    new Person(null, "Grace", 29),
                    new Person(null, "Helen", 22),
                    new Person(null, "Jesper", 28),
                    new Person(null, "Jon", 35)
            ).flatMap(reactiveMongoRepository::save);
            log.info("Data initialization completed...");
        };
    }
}
