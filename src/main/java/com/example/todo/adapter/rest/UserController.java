package com.example.todo.adapter.rest;

import com.example.todo.application.UserService;
import com.example.todo.application.dto.UserCreateDto;
import com.example.todo.application.dto.UserDto;
import com.example.todo.application.dto.UserListQueryDto;
import com.example.todo.common.ddd.adpter.rest.resource.Response;
import com.example.todo.common.ddd.application.dto.Page;
import com.example.todo.domain.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;


@Api(value = "user")
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "创建新用户")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<String> create(@ApiParam(value = "用户基本信息", required = true) @Valid @RequestBody UserCreateDto userCreateDto) {
        String id = userService.createUser(userCreateDto);
        return new Response<String>(id);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Response<User> getUserById(@PathVariable("id") String id) {
        return new Response<User>(userService.getUserById(id));
    }

    @ApiOperation(value = "更新用户信息")
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public Response<String> update(@PathVariable("id") String id, @RequestBody UserDto userDto) {
        return new Response<String>(userService.updateUser(id, userDto));
    }

    @ApiOperation(value = "删除用户")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/list")
    public Response<Page<User>> getUserList(UserListQueryDto requestParams) {

        return new Response<Page<User>>(userService.findAllUserList(requestParams));
    }


}
