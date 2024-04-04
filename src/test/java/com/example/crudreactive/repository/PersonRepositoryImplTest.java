package com.example.crudreactive.repository;

import com.example.crudreactive.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.BDDMockito.given;

public class PersonRepositoryImplTest {

    private ReactiveMongoRepository repository;
    private PersonRepositoryImpl personRepository;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(ReactiveMongoRepository.class);
        personRepository = new PersonRepositoryImpl(repository);
    }

    @Test
    public void testFindAllByLetterJ() {
        Person john = new Person("1", "John", 30);
        Person jane = new Person("2", "Jane", 25);
        Person mike = new Person("3", "Mike", 35);

        given(repository.findAll()).willReturn(Flux.just(john, jane, mike));

        StepVerifier.create(personRepository.findAllByLetterJ())
                .expectNext(john)
                .expectNext(jane)
                .verifyComplete();
    }

    @Test
    public void testFindByAge() {
        Person john = new Person("1", "John", 30);
        Person jane = new Person("2", "Jane", 25);
        Person mike = new Person("3", "Mike", 35);

        given(repository.findAll()).willReturn(Flux.just(john, jane, mike));

        StepVerifier.create(personRepository.findByAge(30))
                .expectNext(john)
                .verifyComplete();
    }

    @Test
    public void testFindPersonOverAge() {
        Person john = new Person("1", "John", 30);
        Person jane = new Person("2", "Jane", 25);
        Person mike = new Person("3", "Mike", 35);

        given(repository.findAll()).willReturn(Flux.just(john, jane, mike));

        StepVerifier.create(personRepository.findPersonOverAge(30))
                .expectNext(mike)
                .verifyComplete();
    }
}
