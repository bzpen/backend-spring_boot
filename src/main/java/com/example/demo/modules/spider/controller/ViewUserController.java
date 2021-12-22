package com.example.demo.modules.spider.controller;


import com.example.demo.common.util.ExcelUtil;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewUser;
import com.example.demo.modules.spider.param.PageUserRequest;
import com.example.demo.modules.spider.service.IViewUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@RestController
@RequestMapping("/view-user")
@Api(tags = "用户视图控制器")
public class ViewUserController extends BaseController {

    @Resource
    IViewUserService iViewUserService;

    @GetMapping("gets")
    @ApiOperation("获取用户列表/查询")
    public Result gets(PageUserRequest request){
        PageResponse<ViewUser> list=iViewUserService.page(request);
        return success(list);
    }

    @GetMapping("get/{id}")
    @ApiOperation("获取单个用户信息")
    public Result get(@PathVariable String id){
        return success(iViewUserService.getById(id));
    }

    @PostMapping("exportExcel")
    @ApiOperation("导出 Excel ")
    public void getExcel(HttpServletResponse response, @RequestBody List<ViewUser> viewUserList) throws IllegalAccessException, IOException,
            InstantiationException {
        List<ViewUser> list = viewUserList;
        if(viewUserList.isEmpty())
            list = iViewUserService.list();
        ExcelUtil.download(response,ViewAdmin.class,list);
    }

}
