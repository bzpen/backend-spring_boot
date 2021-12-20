package com.example.demo.common.email.config;

import com.example.demo.common.email.service.impl.EmailCodeServiceImpl;
import com.example.demo.common.email.sucrity.authentication.email.EmailAuthenticationFilter;
import com.example.demo.common.email.sucrity.authentication.email.EmailAuthenticationProvider;
import com.example.demo.common.secure.process.SecureLoginFailureHandler;
import com.example.demo.common.secure.process.SecureLoginSuccessHandler;
import com.example.demo.modules.sys.service.SysUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/19
 */
@Component
public class EmailCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    /**
     * 自定义登陆成功处理器
     */
    @Resource
    private SecureLoginSuccessHandler secureAuthenticationSuccessHandler;


    /**
     * 自定义登陆失败处理器
     */
    @Resource
    private SecureLoginFailureHandler secureAuthenticationFailureHandler;

    /**
     * 验证码服务类
     */
    @Resource
    private EmailCodeServiceImpl emailCodeService;

    @Resource
    private SysUserService sysUserService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        EmailAuthenticationFilter filter = new EmailAuthenticationFilter(emailCodeService) ;
        filter .setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        filter .setAuthenticationSuccessHandler(secureAuthenticationSuccessHandler);
        filter .setAuthenticationFailureHandler(secureAuthenticationFailureHandler);

        EmailAuthenticationProvider provider = new EmailAuthenticationProvider(sysUserService) ;
        http.authenticationProvider(provider)
                .addFilterAfter(filter , UsernamePasswordAuthenticationFilter.class);
    }
}
