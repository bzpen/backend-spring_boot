package com.example.demo.modules.spider.mapper;

import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.modules.spider.entity.ViewSample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.spider.param.PageSampleRequest;
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
public interface ViewSampleMapper extends BaseMapper<ViewSample> {

    /**
     *  查询分页实现
     *
     * @param request
     * @return
     */
    List<ViewSample> selectViewSample(PageSampleRequest request);

    /**
     * 个人上传列表查询
     *
     * @param username
     * @return
     */
    List<ViewSample> selectUserViewSample(String username);

    /**
     * 前台筛选实现
     *
     * @param request
     * @return
     */
    List<ViewSample> screen(PageSampleRequest request);
}
