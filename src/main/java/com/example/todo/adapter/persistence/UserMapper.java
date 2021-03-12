package com.example.todo.adapter.persistence;

import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    void update(@Param("user") User user, @Param("id") String id);

    void delete(@Param("id") String id);

    User findById(@Param("id") String id);

    User findByName(@Param("username") String username);

    List<User> findAll(@Param("queryParams") UserDto params);

}
