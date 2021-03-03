package com.example.todo.adapter.persistence;

import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.model.User;
import com.example.todo.domain.reponsitory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class UserRepositoryIml implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user, String id) {
        userMapper.update(user, id);
    }

    @Override
    public List<User> findAll(UserDto params) {
        return userMapper.findAll(params);
    }
}
