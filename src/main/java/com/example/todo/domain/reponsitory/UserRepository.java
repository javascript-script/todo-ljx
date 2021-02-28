package com.example.todo.domain.reponsitory;


import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.model.User;
import com.github.pagehelper.Page;


public interface UserRepository {
    void insert(User user);

    User findById(String id);

    void delete(String id);

    void update(User user, String id);

    Page<User> findAll(UserDto params);
}
