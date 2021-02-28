package com.example.todo.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListRequestDto {
    private int pageSize = 10;
    private int pageNum = 1;
    private String username;
    private String email;
    private int age;
}
