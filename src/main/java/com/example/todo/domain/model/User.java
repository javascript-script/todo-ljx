package com.example.todo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.age = age;
    }

}
