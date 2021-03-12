
package com.example.todo.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Setter
@Getter
@Builder
@Data
public class UserCreateDto implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "请输入正确的邮箱地址")
    private String email;

    @NotNull
    @Min(value = 18,message = "年龄最小18")
    @Max(value = 80,message = "年龄最小80")
    private int age;

    @NotNull
    private String password;

}
