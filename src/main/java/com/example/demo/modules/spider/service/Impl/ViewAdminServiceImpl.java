package com.example.demo.modules.spider.service.Impl;

import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.base.page.Pageable;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.mapper.ViewAdminMapper;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.param.PageViewAdminRequest;
import com.example.demo.modules.spider.service.IViewAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@Service
public class ViewAdminServiceImpl extends ServiceImpl<ViewAdminMapper, ViewAdmin> implements IViewAdminService {

    @Resource
    ViewAdminMapper viewAdminMapper;

    @Override
    public PageResponse<ViewAdmin> page(PageViewAdminRequest request) {
        return Pageable.of(request,() -> viewAdminMapper.selectViewAdmin(request));
    }
}
