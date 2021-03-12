package com.example.todo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    private String id;
    private String username;
    private String email;
    private String roleName = "USER"; // TODO 后面实现多角色，多对多映射关系
    private String password;
    private int age;

    public User(String username, String email, int age, String password) {
        this.id = UUID.randomUUID().toString();
        this.roleName = "USER";
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String roleName = this.getRoleName();
        authorities.add(new SimpleGrantedAuthority(roleName));
        return authorities;
    }

    //帐号是否不过期，false则验证不通过
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //帐号是否不锁定，false则验证不通过
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证是否不过期，false则验证不通过
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //该帐号是否启用，false则验证不通过
    @Override
    public boolean isEnabled() {
        return true;
    }
}
