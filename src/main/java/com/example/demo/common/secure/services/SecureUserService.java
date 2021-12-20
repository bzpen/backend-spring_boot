package com.example.demo.common.secure.services;

import com.example.demo.modules.sys.entity.SysRole;
import com.example.demo.modules.sys.entity.SysUser;
import com.example.demo.modules.sys.mapper.SysRoleMapper;
import com.example.demo.modules.sys.mapper.SysUserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户的服务实现
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureUserService implements UserDetailsService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 加载用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        if(sysUser ==null){
            throw new UsernameNotFoundException("USERNAME NOT SUPPORT");
        }
        sysUser.setAuthorities(loadAuthorities(sysUser.getRoleId()));
        sysUser.setRole(loadRoles(sysUser.getRoleId()));
        return sysUser;
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
}
