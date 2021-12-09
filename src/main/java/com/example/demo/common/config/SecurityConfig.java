package com.example.demo.common.config;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.process.*;
import com.example.demo.common.secure.uutoken.SecureUserTokenSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Security 安全核心配置类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
     * 自定义注销成功处理器
     */
    @Resource
    private SecureLogoutSuccessHandler secureLogoutSuccessHandler;

    /**
     * 自定义暂无权限处理器
     */
    @Resource
    private SecureNoPermissionHandler secureAuthAccessDeniedHandler;

    /**
     * 自定义未登录的处理器
     */
    @Resource
    private SecureNoAuthenticationHandler secureNoAuthenticationHandler;

    /**
     * 密码加密方式 BCrypt
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Web Configure 核心配置
     */
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/favicon.ico");
    }

    /**
     * Http Security 核心配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 不进行权限验证的请求或资源
                .antMatchers(Constant.Security.openApi).permitAll()
                // 其他的需要登陆后才能访问
                .anyRequest().authenticated()
                .and()
                // 配置未登录自定义处理类
                .httpBasic().authenticationEntryPoint(secureNoAuthenticationHandler)
                .and()
                // 配置登陆地址
                .formLogin()
                // 去除自定义登陆界面
//                .loginPage("/login")
                .loginProcessingUrl(Constant.Security.LOGIN_URL)
                // 配置登陆成功自定义处理类
                .successHandler(secureAuthenticationSuccessHandler)
                // 配置登陆失败自定义处理类
                .failureHandler(secureAuthenticationFailureHandler)
                .and()
                // 配置登出地址
                .logout()
                .logoutUrl(Constant.Security.LOGOUT_URL)
                // 配置用户登出自定义处理类
                .logoutSuccessHandler(secureLogoutSuccessHandler)
                .and()
                // 配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(secureAuthAccessDeniedHandler);

        // 取消跨站请求伪造防护
        http.csrf().disable();

        // 基于 Token 不需要 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Token 过滤器
        http.addFilterBefore(new SecureUserTokenSupport(), UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        http.headers().cacheControl();

        // 开启 Security 跨域
        http.cors();
    }

}
