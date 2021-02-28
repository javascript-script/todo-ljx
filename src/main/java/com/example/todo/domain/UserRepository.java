package com.example.todo.domain;


import com.example.todo.application.dto.UserDto;
import com.github.pagehelper.Page;


public interface UserRepository {
    void insert(User user);

    User findById(String id);

    void delete(String id);

    void update(User user, String id);

    Page<User> findAll(UserDto params);
}
