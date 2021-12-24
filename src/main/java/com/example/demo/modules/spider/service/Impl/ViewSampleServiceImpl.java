package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.secure.uutoken.SecureUserToken;
import com.example.demo.common.secure.uutoken.SecureUserTokenService;
import com.example.demo.common.secure.uutoken.SecureUserTokenSupport;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.base.page.Pageable;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.mapper.ViewSampleMapper;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.service.IViewSampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    SecureUserTokenService customUserDetailsTokenService;

    @Resource
    ViewSampleMapper viewSampleMapper;

    @Override
    public PageResponse<ViewSample> list(PageSampleRequest request) {
        return Pageable.of(request,() -> viewSampleMapper.selectViewSample(request));
    }

    @Override
    public PageResponse<ViewSample> list_user(HttpServletRequest request,PageSampleRequest pageRequest) {

        String tokenHeader = request.getHeader(Constant.Token.TOKEN_HEADER);
        // token verify
        SecureUser secureUser;
        SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenHeader);
        secureUser = userToken.getSecureUser();

        return Pageable.of(pageRequest,() -> viewSampleMapper.selectUserViewSample(secureUser.getUsername()));
    }

    @Override
    public PageResponse<ViewSample> screen(PageSampleRequest request) {
        return Pageable.of(request,() -> viewSampleMapper.screen(request));
    }
}
