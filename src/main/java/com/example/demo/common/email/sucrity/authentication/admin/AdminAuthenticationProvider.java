package com.example.demo.common.email.sucrity.authentication.admin;


import com.example.demo.modules.sys.mapper.SysAdminMapper;
import com.example.demo.modules.sys.service.impl.SysAdminServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 邮件验证过滤器
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class AdminAuthenticationProvider implements AuthenticationProvider {

    private SysAdminServiceImpl sysAdminService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AdminAuthenticationProvider(SysAdminServiceImpl sysAdminService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.sysAdminService=sysAdminService;
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
        AdminAuthenticationToken token = (AdminAuthenticationToken) authentication;
        // 从数据库查询 数据
        UserDetails user = sysAdminService.selectByUsername((String) token.getPrincipal());

        System.out.println(token.getPrincipal());
        if (user == null) {
            throw new UsernameNotFoundException("无法获取用户信息");
        }

        if(!bCryptPasswordEncoder.matches((String)token.getCredentials(),user.getPassword())){
            throw new BadCredentialsException("密码错误");
        }
        System.out.println(user.getAuthorities());

        AdminAuthenticationToken result =
                new AdminAuthenticationToken(user, user.getAuthorities());

        result.setDetails(token.getDetails());
        return result;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return AdminAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
