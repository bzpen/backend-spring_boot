package com.example.demo.modules.sys.service.impl;

import com.example.demo.modules.sys.entity.SysUser;
import com.example.demo.modules.sys.mapper.SysUserMapper;
import com.example.demo.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }


    @Override
    public UserDetails getByEmail(String email) {
        return sysUserMapper.selectByEmail(email);
    }
}
