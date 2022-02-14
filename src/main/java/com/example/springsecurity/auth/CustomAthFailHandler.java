package com.example.springsecurity.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAthFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String loginId = request.getParameter("j_username");
        String errorMsg = "";

        if (exception instanceof BadCredentialsException) {
            loginFailureCount(loginId);
            errorMsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            loginFailureCount(loginId);
            errorMsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof DisabledException) {
            errorMsg = "계정정이 비활성화되습니다. 관리자에게 문의하세요.";
        } else if (exception instanceof CredentialsExpiredException) {
            errorMsg = "비밀번호 유효기간이 만료되었습니다. 관리자에게 문의하세요.";
        }

        request.setAttribute("username", loginId);
        request.setAttribute("error_message", errorMsg);

        request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
    }

    protected void loginFailureCount(String loginId) {

    }
}
