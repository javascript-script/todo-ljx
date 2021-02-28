package com.example.todo.domain;


public interface UserRepository {
    void insert(User user);

    User findById(String id);

    void delete(String id);

    void update(User user, String id);
}
