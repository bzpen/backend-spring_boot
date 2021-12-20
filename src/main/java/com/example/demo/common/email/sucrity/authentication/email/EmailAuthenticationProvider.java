package com.example.demo.common.email.sucrity.authentication.email;

import com.example.demo.modules.sys.service.SysUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 邮件验证过滤器
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class EmailAuthenticationProvider implements AuthenticationProvider {

    private SysUserService tbUserService;

    public EmailAuthenticationProvider(SysUserService tbUserService){
        this.tbUserService=tbUserService;
    }

    /**
     * 认证
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }

        EmailAuthenticationToken token = (EmailAuthenticationToken) authentication;
        // 从数据库查询 数据
        UserDetails user = tbUserService.getByEmail((String) token.getPrincipal());

        System.out.println(token.getPrincipal());
        if (user == null) {
            throw new BadCredentialsException("验证码错误");
        }
        System.out.println(user.getAuthorities());

        EmailAuthenticationToken result =
                new EmailAuthenticationToken(user, user.getAuthorities());

        result.setDetails(token.getDetails());

        return result;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return EmailAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
