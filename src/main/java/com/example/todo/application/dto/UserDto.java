package com.example.todo.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@Builder
@Data
public class UserDto implements Serializable {
    @NotBlank(message = "用户名")
    private String username;
    private String email;
    private int age;

}
