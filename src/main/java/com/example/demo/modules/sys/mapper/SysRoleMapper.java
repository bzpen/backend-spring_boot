package com.example.demo.modules.sys.mapper;

import com.example.demo.modules.sys.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 获取用户角色
     *
     * @param roleId 角色编号
     * @return {@link SysRole}
     */
    SysRole selectRoleByUserId(String roleId);
}
