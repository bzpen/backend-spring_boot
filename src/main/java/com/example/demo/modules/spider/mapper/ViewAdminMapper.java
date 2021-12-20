package com.example.demo.modules.spider.mapper;

import com.example.demo.modules.spider.entity.ViewAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.spider.param.PageViewAdminRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@Mapper
public interface ViewAdminMapper extends BaseMapper<ViewAdmin> {

    /**
     * 查询管理员列表
     *
     * @param request
     * @return
     */
    List<ViewAdmin> selectViewAdmin(PageViewAdminRequest request);
}
