package com.example.todo.adapter.persistence;

import com.example.todo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    void update(@Param("user") User user);

    void delete(@Param("id") String id);

    Optional<User> findById(@Param("id") String id);

}
