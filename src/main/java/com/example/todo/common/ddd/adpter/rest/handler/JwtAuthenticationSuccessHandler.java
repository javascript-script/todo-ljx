package com.example.todo.common.ddd.adpter.rest.handler;

import com.example.todo.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@Slf4j
@Component("jwtAuthenticationSuccessHandler")
public class JwtAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, Authentication authentication)
        throws ServletException, IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            httpServletRequest.getSession().setAttribute("userDetail", user);

            String role = "";
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                role = authority.getAuthority();

            }
            String token = JwtTokenUtils.createToken(user.getUsername(), role, true);
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();

            out.write("{\"rspCode\":\"000000\",\"rspMsg\":\"登录成功\",\"data\":{\"token\":\"" + JwtTokenUtils.TOKEN_PREFIX + token + "\"}}");

            out.flush();
            out.close();
        }

    }

}
