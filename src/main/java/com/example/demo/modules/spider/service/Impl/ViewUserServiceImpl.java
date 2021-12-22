package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.web.base.page.PageRequest;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.base.page.Pageable;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewUser;
import com.example.demo.modules.spider.mapper.ViewUserMapper;
import com.example.demo.modules.spider.param.PageUserRequest;
import com.example.demo.modules.spider.service.IViewUserService;
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
public class ViewUserServiceImpl extends ServiceImpl<ViewUserMapper, ViewUser> implements IViewUserService {


    @Resource
    ViewUserMapper viewUserMapper;

    @Override
    public PageResponse<ViewUser> page(PageUserRequest request) {
        return Pageable.of(request,()->viewUserMapper.selectViewUser(request));
    }

}
