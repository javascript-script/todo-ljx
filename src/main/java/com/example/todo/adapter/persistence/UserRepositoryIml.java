package com.example.todo.adapter.persistence;

import com.example.todo.domain.User;
import com.example.todo.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryIml implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public void update(User user) {

    }
}
