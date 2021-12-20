package com.example.demo.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.sys.entity.SysAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Mapper
public interface SysAdminMapper extends BaseMapper<SysAdmin> {

    /**
     * 根 据 用 户 名 查 询
     *
     * @param username
     * @return
     */
    SysAdmin selectByUsername(String username);
}
