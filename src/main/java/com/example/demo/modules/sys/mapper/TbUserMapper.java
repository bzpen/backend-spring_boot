package com.example.demo.modules.sys.mapper;

import com.example.demo.common.email.entity.Email;
import com.example.demo.modules.sys.entity.TbUser;
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
public interface TbUserMapper extends BaseMapper<TbUser> {

    /**
     * 根据 username 获取用户
     *
     * @param username 用户名称
     * @return {@link TbUser}
     */
    TbUser selectByUsername(@Param("username") String username);

    /**
     * 根据 email 获取用户
     *
     * @param email
     * @return {@link TbUser}
     */
    TbUser selectByEmail(@Param("email")String email);

}
