package com.example.demo.modules.spider.service.Impl;

import com.example.demo.modules.spider.entity.TbAdmin;
import com.example.demo.modules.spider.mapper.TbAdminMapper;
import com.example.demo.modules.spider.service.ITbAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2021-12-15
 */
@Service
public class TbAdminServiceImpl extends ServiceImpl<TbAdminMapper, TbAdmin> implements ITbAdminService {

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    TbAdminMapper tbAdminMapper;

    @Override
    public boolean save(TbAdmin entity) {
        TbAdmin admin=TbAdmin.builder()
                .id(null)
                .deleted(false)
                .enable(true)
                .userPhoto("/root/java/java_backend/admin/head.jpg")
                .locked(false)
                .name(entity.getName())
                .role(4)
                .username(entity.getUsername())
                .password(bCryptPasswordEncoder.encode(entity.getPassword()))
                .build();
        return super.save(admin);
    }


    @Override
    public boolean delList(List<Integer> list) {
        return tbAdminMapper.delList(list);
    }
}
