package com.example.crudreactive.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration(proxyBeanMethods = false)
public class PersonRouter {

    @Bean
    public RouterFunction<?> route(PersonHandler personHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/person"), personHandler::getPerson);
    }

    @Bean
    public RouterFunction<?> routeSavePerson(PersonHandler personHandler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/person"), personHandler::savePerson);
    }

    @Bean
    public RouterFunction<?> routeByAge(PersonHandler personHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/person/age/{age}"), personHandler::getPersonByAge);
    }

    @Bean
    public RouterFunction<?> routeByLetterJ(PersonHandler personHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/person/j"), personHandler::getPersonsByLetterJ);
    }
}
