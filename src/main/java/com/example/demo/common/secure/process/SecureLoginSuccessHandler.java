package com.example.demo.common.secure.process;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.secure.uutoken.SecureResultToken;
import com.example.demo.common.secure.uutoken.SecureUserToken;
import com.example.demo.common.secure.uutoken.SecureUserTokenService;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import com.example.demo.modules.spider.entity.Log;
import com.example.demo.modules.spider.service.ILogService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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

    @Resource
    private ILogService iLogService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecureUser secureUser = (SecureUser) authentication.getPrincipal();

        System.out.println(secureUser.toString());
        SecureUserToken userToken = secureUserTokenService.createToken(secureUser);

        SecureResultToken resultToken = SecureResultToken.builder()
                .token(secureUserTokenService.saveToken(userToken))
                .username(secureUser.getUsername())
                .userPhoto(Constant.Img.VIRTUAL_IMG_PATH + secureUser.getUserPhoto())
                .email(secureUser.getEmail())
                .registTime(secureUser.getRegistTime())
                .upLoginTime(secureUser.getUpLoginTime())
                .build();
        Log log = Log.builder()
                .role(secureUser.getRole().getId())
                .action(Constant.Log.ACTION_LOGIN)
                .user(secureUser.getUsername())
                .build();
        iLogService.save(log);

        resultToken.setUpLoginTime(LocalDateTime.now().toString());

        ServletUtil.writeJson(Result.success(ResultCode.LOGIN_SUCCESS,resultToken));
    }

}
