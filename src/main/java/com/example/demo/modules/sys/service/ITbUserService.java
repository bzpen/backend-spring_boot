package com.example.demo.modules.sys.service;

import com.example.demo.modules.sys.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
public interface ITbUserService extends IService<TbUser> {

    UserDetails getByEmail(String email);
}
