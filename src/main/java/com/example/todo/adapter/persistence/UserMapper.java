package com.example.todo.adapter.persistence;

import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    void update(@Param("user") User user, @Param("id") String id);

    void delete(@Param("id") String id);

    User findById(@Param("id") String id);

    Page<User> findAll(@Param("queryParams") UserDto params);

}
