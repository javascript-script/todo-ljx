package com.example.todo.domain;



import java.util.Optional;

public interface UserRepository {
    void insert(User user);

    Optional<User> findById(String id);

    String delete(String id);

    void update(User user);
}
