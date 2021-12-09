package com.example.demo.common.secure.services;

import com.example.demo.modules.sys.entity.TbRole;
import com.example.demo.modules.sys.entity.TbUser;
import com.example.demo.modules.sys.mapper.TbRoleMapper;
import com.example.demo.modules.sys.mapper.TbUserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
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
    private TbUserMapper tbUserMapper;

    @Resource
    private TbRoleMapper tbRoleMapper;

    /**
     * 加载用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = tbUserMapper.selectByUsername(username);
        if(tbUser==null){
            throw new UsernameNotFoundException("USERNAME NOT SUPPORT");
        }
        tbUser.setAuthorities(loadAuthorities(tbUser.getRoleId()));
        tbUser.setRole(loadRoles(tbUser.getUserId()));
        return tbUser;
    }

    public Set<? extends GrantedAuthority> loadAuthorities(String roleId){
        Set<SimpleGrantedAuthority> authorities =new HashSet<>();
        TbRole role = loadRoles(roleId);
        if(role != null){
            SimpleGrantedAuthority authority =new SimpleGrantedAuthority(role.getType());
            authorities.add(authority);
        }
        return authorities;
    }

    public TbRole loadRoles(String roleId){
        return tbRoleMapper.selectRoleByUserId(roleId);
    }
}
