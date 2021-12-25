package com.example.demo.common.email.sucrity.authentication.email;

import com.example.demo.modules.sys.entity.SysRole;
import com.example.demo.modules.sys.entity.SysUser;
import com.example.demo.modules.sys.mapper.SysRoleMapper;
import com.example.demo.modules.sys.service.SysUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * 邮件验证过滤器
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class EmailAuthenticationProvider implements AuthenticationProvider {

    private SysUserService tbUserService;

    private SysRoleMapper sysRoleMapper;

    public EmailAuthenticationProvider(SysUserService tbUserService,SysRoleMapper sysRoleMapper){
        this.tbUserService=tbUserService;
        this.sysRoleMapper=sysRoleMapper;
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
        SysUser user = tbUserService.getByEmail((String) token.getPrincipal());

        System.out.println(token.getPrincipal());
        if (user == null) {
            throw new BadCredentialsException("验证码错误");
        }

        user.setAuthorities(loadAuthorities(user.getRoleId()));
        user.setRole(loadRoles(user.getRoleId()));

        System.out.println(user.getAuthorities());

        EmailAuthenticationToken result =
                new EmailAuthenticationToken(user, user.getAuthorities());

        result.setDetails(token.getDetails());

        return result;
    }

    public Set<? extends GrantedAuthority> loadAuthorities(String roleId){
        Set<SimpleGrantedAuthority> authorities =new HashSet<>();
        SysRole role = loadRoles(roleId);
        if(role != null){
            SimpleGrantedAuthority authority =new SimpleGrantedAuthority(role.getName());
            authorities.add(authority);
        }
        return authorities;
    }

    public SysRole loadRoles(String roleId){
        return sysRoleMapper.selectRoleByUserId(roleId);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return EmailAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
