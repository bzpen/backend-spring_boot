package com.example.demo.modules.sys.mapper;

import com.example.demo.modules.sys.entity.TbRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Mapper
public interface TbRoleMapper extends BaseMapper<TbRole> {

    /**
     * 获取用户角色
     *
     * @param roleId 角色编号
     * @return {@link TbRole}
     */
    TbRole selectRoleByUserId(String roleId);
}
