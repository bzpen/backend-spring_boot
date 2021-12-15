package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.service.IViewSampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@RestController
@RequestMapping("view-sample")
@Api(tags = "蜘蛛序列视图接口")
public class ViewSampleController extends BaseController {

    @Resource
    IViewSampleService iViewSampleService;

    @GetMapping("list")
    @ApiOperation("蜘蛛序列数据查询")
    public Result list(PageSampleRequest request){
        PageResponse<ViewSample> list = iViewSampleService.list(request);
        return Result.success(list);
    }

    @GetMapping("list-user")
    @ApiOperation("个人蜘蛛序列数据查询")
    public Result list_user(HttpServletRequest request, PageSampleRequest pageRequest){
        PageResponse<ViewSample> list = iViewSampleService.list_user(request,pageRequest);
        return Result.success(list);
    }

}
