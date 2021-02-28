package com.example.todo.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDto {
    private String username;
    private String email;
    private int age;
}
