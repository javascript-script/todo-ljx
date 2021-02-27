package com.example.todo.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserDto {
    private String username;
    private String email;
    private int age;
}
