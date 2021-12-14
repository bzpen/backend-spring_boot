package com.example.demo.modules.spider.mapper;

import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.entity.ViewUser;
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
public interface ViewUserMapper extends BaseMapper<ViewUser> {


    /**
     * 查询分页实现
     *
     * @param request
     * @return
     */
    List<ViewSample> selectViewSample(PageSampleRequest request);

}
