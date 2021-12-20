package com.example.demo.modules.sys.mapper;

import com.example.demo.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据 username 获取用户
     *
     * @param username 用户名称
     * @return {@link SysUser}
     */
    SysUser selectByUsername(@Param("username") String username);

    /**
     * 根据 email 获取用户
     *
     * @param email
     * @return {@link SysUser}
     */
    SysUser selectByEmail(@Param("email")String email);

}
