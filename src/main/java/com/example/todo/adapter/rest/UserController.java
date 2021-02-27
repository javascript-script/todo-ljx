package com.example.todo.adapter.rest;

import com.example.todo.application.UserService;
import com.example.todo.application.dto.CreateUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "创建新用户")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ApiParam(value = "用户基本信息", required = true) @RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

}
