package com.example.demo.modules.spider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.spider.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

    /**
     * 升级用户权限
     *
     * @param id
     * @return
     */
    int up(String id);

    /**
     * 降低用户权限
     *
     * @param id
     * @return
     */
    int down(String id);


    /**
     * 批 量 删 除 用 户
     *
     * @param List
     * @return
     */
    boolean delList(List<TbUser> List);
}
