package com.example.demo.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.demo.modules.sys.entity.SysAdmin;
import com.example.demo.modules.sys.mapper.SysAdminMapper;
import com.example.demo.modules.sys.service.SysAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {

    @Resource
    SysAdminMapper sysAdminMapper;

    @Override
    public SysAdmin selectByUsername(String username) {
        return sysAdminMapper.selectByUsername(username);
    }
}
