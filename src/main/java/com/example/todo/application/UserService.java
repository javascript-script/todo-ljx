package com.example.todo.application;

import com.example.todo.application.dto.UserDto;
import com.example.todo.domain.User;
import com.example.todo.domain.UserRepository;
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
        userRepository.update(user);
        return user.getId();
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
