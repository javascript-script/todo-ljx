package com.example.todo.application;

import com.example.todo.application.dto.CreateUserDto;
import com.example.todo.domain.User;
import com.example.todo.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String createUser(CreateUserDto createUserDto) {
        User user = new User(createUserDto.getUsername(), createUserDto.getEmail(), createUserDto.getAge());
        userRepository.insert(user);
        return user.getId();
    }
}
