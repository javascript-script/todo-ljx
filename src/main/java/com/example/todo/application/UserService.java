package com.example.todo.application;

import com.example.todo.application.dto.UserDto;
import com.example.todo.application.dto.command.UserListQueryCommand;
import com.example.todo.common.ddd.application.dto.Page;
import com.example.todo.domain.model.User;
import com.example.todo.domain.reponsitory.UserRepository;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String createUser(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getEmail(), userDto.getAge());
        userRepository.insert(user);
        return user.getId();
    }

    public User getUserById(String id) {
        return userRepository.findById(id);
    }

    public String updateUser(String id, UserDto userDto) {
        User user = userRepository.findById(id);
        user.setUsername(userDto.getUsername());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        userRepository.update(user, id);
        return user.getId();
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }

    public Page<User> findAllUserList(UserListQueryCommand requestParams) {
        UserDto params = UserDto.builder()
            .username(requestParams.getUsername())
            .email(requestParams.getEmail())
            .age(requestParams.getAge())
            .build();
        PageHelper.startPage(requestParams.getPageNum(), requestParams.getPageSize(), true);
        return new Page<User>(userRepository.findAll(params), requestParams.getPageSize(), requestParams.getPageNum(), PageHelper.getLocalPage().getTotal());
    }
}
