package com.example.demo.common.email.sucrity.authentication.user;

import com.example.demo.modules.sys.mapper.TbUserMapper;
import com.example.demo.modules.sys.service.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

/**
 * 邮件验证过滤器
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private TbUserMapper tbUserMapper;

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
        UserAuthenticationToken token = (UserAuthenticationToken) authentication;
        // 从数据库查询 数据
        UserDetails user = tbUserMapper.selectByUsername((String) token.getPrincipal());

        System.out.println(token.getPrincipal());
        if (user == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        System.out.println(user.getAuthorities());

        UserAuthenticationToken result =
                new UserAuthenticationToken(user, user.getAuthorities());

        result.setDetails(token.getDetails());
        return result;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return UserAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
