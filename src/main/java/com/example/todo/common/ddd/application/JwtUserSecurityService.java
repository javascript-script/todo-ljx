package com.example.todo.common.ddd.application;

import com.example.todo.domain.model.User;
import com.example.todo.domain.reponsitory.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class JwtUserSecurityService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug((username));
        User user = userRepository.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!!");
        }
        log.debug("After parser, username={}", user.getUsername());
        return  user;
    }
}
