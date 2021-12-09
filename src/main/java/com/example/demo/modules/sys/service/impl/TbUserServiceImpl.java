package com.example.demo.modules.sys.service.impl;

import com.example.demo.modules.sys.entity.TbUser;
import com.example.demo.modules.sys.mapper.TbUserMapper;
import com.example.demo.modules.sys.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
