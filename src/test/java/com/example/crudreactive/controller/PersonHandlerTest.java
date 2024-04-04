package com.example.crudreactive.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonHandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetPerson() {
        webTestClient.get().uri("/person")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Alice")
                .jsonPath("$[1].name").isEqualTo("David")
                .jsonPath("$[2].name").isEqualTo("Charlie");
    }

    @Test
    public void testGetPersonByAge() {
        webTestClient.get().uri("/person/age/23")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Alice")
                .jsonPath("$[0].age").isEqualTo(23);
    }

    @Test
    public void testGetPersonsByLetterJ() {
        webTestClient.get().uri("/person/j")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Jesper")
                .jsonPath("$[1].name").isEqualTo("Jon");
    }

    @Test
    public void testSavePerson() {
        webTestClient.post().uri("/person")
                .header("Content-Type", "application/json")
                .bodyValue("{\"name\":\"Karl\",\"age\":30}")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Karl")
                .jsonPath("$[0].age").isEqualTo(30);
    }

}
