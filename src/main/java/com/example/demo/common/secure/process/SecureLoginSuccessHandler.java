package com.example.demo.common.secure.process;

import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.secure.uutoken.SecureResultToken;
import com.example.demo.common.secure.uutoken.SecureUserToken;
import com.example.demo.common.secure.uutoken.SecureUserTokenService;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security 登录成功处理类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private SecureUserTokenService secureUserTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecureUser secureUser = (SecureUser) authentication.getPrincipal();

        SecureUserToken userToken = secureUserTokenService.createToken(secureUser);

        SecureResultToken resultToken = SecureResultToken.builder()
                .token(secureUserTokenService.saveToken(userToken))
                .username(secureUser.getUsername())
                .userPhoto(secureUser.getUserPhoto())
                .email(secureUser.getEmail())
                .registTime(secureUser.getRegistTime())
                .upLoginTime(secureUser.getUpLoginTime())
                .build();

        ServletUtil.writeJson(Result.success(ResultCode.LOGIN_SUCCESS,resultToken));
    }

}
