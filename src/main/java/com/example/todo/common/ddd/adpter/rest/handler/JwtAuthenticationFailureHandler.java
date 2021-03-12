package com.example.todo.common.ddd.adpter.rest.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("jwtAuthenticationFailureHandler")
public class JwtAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {
        httpServletRequest.setCharacterEncoding("UTF-8");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"status\":\"error\",\"message\":\"用户名或密码错误\"}");
        out.flush();
        out.close();
    }
}
