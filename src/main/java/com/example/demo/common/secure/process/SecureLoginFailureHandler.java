package com.example.demo.common.secure.process;

import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security 登录失败处理
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();

        if(e instanceof UsernameNotFoundException){
            ServletUtil.writeJson(Result.failure(ResultCode.USER_USERNAME_NOT_FOUND));
            return;
        }
        if(e instanceof LockedException){
            ServletUtil.writeJson(Result.failure(ResultCode.USER_LOCKED));
            return;
        }
        if(e instanceof BadCredentialsException){
            ServletUtil.writeJson(Result.failure(ResultCode.USER_BAD_CREDENTIALS));
            return;
        }
        if(e instanceof AccountExpiredException){
            ServletUtil.writeJson(Result.failure(ResultCode.USER_EXPIRED));
            return;
        }
        if(e instanceof DisabledException){
            ServletUtil.writeJson(Result.failure(ResultCode.USER_NOT_ENABLE));
        }

        ServletUtil.writeJson(Result.failure(ResultCode.LOGIN_FAILURE));

    }
}
