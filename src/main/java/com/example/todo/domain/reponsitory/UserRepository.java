package com.example.todo.domain.reponsitory;

import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.model.User;

import java.util.List;


public interface UserRepository {
    void insert(User user);

    User findById(String id);

    void delete(String id);

    void update(User user, String id);

    User findByName(String username);

    List<User> findAll(UserDto params);
}
