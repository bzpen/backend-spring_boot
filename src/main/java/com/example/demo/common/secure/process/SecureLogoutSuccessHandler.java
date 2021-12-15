package com.example.demo.common.secure.process;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.uutoken.SecureUserTokenService;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security 注销成功处理类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureLogoutSuccessHandler implements LogoutSuccessHandler {

    @Resource
    private SecureUserTokenService customUserDetailsTokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token = httpServletRequest.getHeader(Constant.Token.TOKEN_HEADER).replaceFirst(Constant.Token.TOKEN_PREFIX, "");

        customUserDetailsTokenService.destroyToken(token);

        ServletUtil.writeJson(Result.success(ResultCode.LOGOUT_SUCCESS));
    }
}
