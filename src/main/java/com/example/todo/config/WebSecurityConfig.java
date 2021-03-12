package com.example.todo.config;

import com.example.todo.common.ddd.adpter.rest.filter.AuthorizationFilter;
import com.example.todo.common.ddd.application.JwtUserSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler jwtAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**").
            //指定登录认证的Controller
                formLogin().usernameParameter("username").passwordParameter("password").loginPage("/api/user/login").successHandler(
            jwtAuthenticationSuccessHandler).failureHandler(jwtAuthenticationFailureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/user/**").authenticated()
            .and()
            .addFilter(new AuthorizationFilter(authenticationManager()));

        http.logout().permitAll();
        http.cors().and().csrf().ignoringAntMatchers("/api/**");

    }

    @Bean
    UserDetailsService JwtUserSecurityService() {
        return new JwtUserSecurityService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(JwtUserSecurityService()).passwordEncoder(new BCryptPasswordEncoder() {
        });
    }

}
