package com.example.demo.modules.spider.controller;


import com.example.demo.common.util.ExcelUtil;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbAdmin;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.param.PageViewAdminRequest;
import com.example.demo.modules.spider.service.IViewAdminService;
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
@RequestMapping("/view-admin")
@Api(tags = "管理员视图操作接口")
public class ViewAdminController extends BaseController {

    @Resource
    IViewAdminService iViewAdminService;

    @ApiOperation("管理员查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id){
        return success(iViewAdminService.getById(id));
    }


    @ApiOperation("管理员列表获取/搜索")
    @GetMapping("list")
    public Result list(PageViewAdminRequest request){
        PageResponse<ViewAdmin> list = iViewAdminService.page(request);
        return success(list);
    }

    @PostMapping("exportExcel")
    @ApiOperation("导出 Excel ")
    public void getExcel(HttpServletResponse response, @RequestBody List<ViewAdmin> viewAdminList) throws IllegalAccessException, IOException,
            InstantiationException {
        List<ViewAdmin> list = viewAdminList;
        if(viewAdminList.isEmpty())
            list = iViewAdminService.list();
        ExcelUtil.download(response,ViewAdmin.class,list);
    }

}
