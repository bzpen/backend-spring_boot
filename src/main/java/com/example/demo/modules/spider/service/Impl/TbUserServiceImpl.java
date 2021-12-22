package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbUser;
import com.example.demo.modules.spider.mapper.TbUserMapper;
import com.example.demo.modules.spider.service.ITbUserService;
import com.example.demo.modules.sys.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    SysUserService sysUserService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 升级用户权限
     *
     * @param id
     * @return
     */
    @Override
    public boolean up(String id) {
        return tbUserMapper.up(id) == 1;
    }

    /**
     * 降低
     *
     * @param id
     * @return
     */
    @Override
    public boolean down(String id) {
        return tbUserMapper.down(id) == 1;
    }

    /**
     * 注 册 新 用 户
     * @param entity
     * @return
     */
    @Override
    public boolean save(TbUser entity) {
        TbUser tbUser = TbUser.builder()
                .id(null)
                .deleted(false)
                .locked(false)
                .enable(true)
                .roleId(2)
                .password(bCryptPasswordEncoder.encode(entity.getPassword()))
                .email(entity.getEmail())
                .username(entity.getUsername())
                .userPhoto("/root/java/java_backend/user/head.jpg")
                .build();
        return super.save(tbUser);
    }

    @Override
    public Result check_username(String username) {
        if(sysUserService.selectByUsername(username)!=null)
            return Result.success("用户名已注册");
        return Result.failure("用户名未注册");
    }


    @Override
    public boolean delList(List<TbUser> tbUserList) {
        return tbUserMapper.delList(tbUserList);
    }
}
