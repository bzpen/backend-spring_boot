package com.example.demo.common.secure.process;

import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security 用户无权限处理类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureNoPermissionHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ServletUtil.writeJson(Result.failure("没有权限"));
    }
}
