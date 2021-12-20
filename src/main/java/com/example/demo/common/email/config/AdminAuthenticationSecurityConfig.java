package com.example.demo.common.email.config;

import com.example.demo.common.email.sucrity.authentication.admin.AdminAuthenticationFilter;
import com.example.demo.common.email.sucrity.authentication.admin.AdminAuthenticationProvider;
import com.example.demo.common.secure.process.SecureLoginFailureHandler;
import com.example.demo.common.secure.process.SecureLoginSuccessHandler;
import com.example.demo.modules.sys.service.impl.SysAdminServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/20
 */
@Component
public class AdminAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

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


    @Resource
    private SysAdminServiceImpl sysAdminService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        AdminAuthenticationFilter filter = new AdminAuthenticationFilter() ;
        filter .setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        filter .setAuthenticationSuccessHandler(secureAuthenticationSuccessHandler);
        filter .setAuthenticationFailureHandler(secureAuthenticationFailureHandler);

        AdminAuthenticationProvider provider = new AdminAuthenticationProvider(sysAdminService,bCryptPasswordEncoder) ;
        http.authenticationProvider(provider)
                .addFilterAfter(filter , UsernamePasswordAuthenticationFilter.class);
    }
}
