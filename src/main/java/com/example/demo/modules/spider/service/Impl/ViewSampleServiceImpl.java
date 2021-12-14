package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.base.page.Pageable;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.mapper.ViewSampleMapper;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.service.IViewSampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@Service
public class ViewSampleServiceImpl extends ServiceImpl<ViewSampleMapper, ViewSample> implements IViewSampleService {

    @Resource
    ViewSampleMapper viewSampleMapper;

    @Override
    public PageResponse<ViewSample> list(PageSampleRequest request) {
        return Pageable.of(request,() -> viewSampleMapper.selectViewSample(request));
    }
}
