package com.example.demo.modules.spider.mapper;

import com.example.demo.modules.spider.entity.TbAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.spider.entity.ViewAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Mapper
public interface TbAdminMapper extends BaseMapper<TbAdmin> {

    /**
     * 管 理 员 批 量 删 除
     *
     * @param list
     * @return
     */
    boolean delList(List<ViewAdmin> list);
}
