package com.example.todo.application;

import com.example.todo.application.dto.UserCreateDto;
import com.example.todo.application.dto.UserDto;
import com.example.todo.application.dto.UserListQueryDto;
import com.example.todo.common.ddd.application.dto.Page;
import com.example.todo.domain.model.User;
import com.example.todo.domain.reponsitory.UserRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String createUser(UserCreateDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println( encoder.encode(userDto.getPassword()));
        User user = new User(userDto.getUsername(),
            userDto.getEmail(),
            userDto.getAge(),
            encoder.encode(userDto.getPassword()));
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

    public Page<User> findAllUserList(UserListQueryDto requestParams) {
        UserDto params = UserDto.builder()
            .username(requestParams.getUsername())
            .email(requestParams.getEmail())
            .age(requestParams.getAge())
            .build();
        PageHelper.startPage(requestParams.getPageNum(), requestParams.getPageSize(), true);

        List<User> list = userRepository.findAll(params);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return new Page<User>(list, requestParams.getPageSize(), requestParams.getPageNum(), pageInfo.getTotal());
    }
}
