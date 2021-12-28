package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/log")
@Api(tags = "日志控制器")
public class LogController extends BaseController {

    @Resource
    ILogService iLogService;

    @GetMapping("getLog")
    @ApiOperation("获取登录记录")
    public Result getLog(){
        return success(iLogService.getLogData());
    }
}
