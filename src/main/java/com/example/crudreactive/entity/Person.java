package com.example.crudreactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
}
