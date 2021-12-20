package com.example.demo.modules.sys.service;

import com.example.demo.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 用户名获取用户信息
     *
     * @param username
     * @return
     */
    UserDetails selectByUsername(@Param("username") String username);

    /**
     * 邮箱获取用户信息
     *
     * @param email
     * @return
     */
    UserDetails getByEmail(@Param("email") String email);
}
