package com.example.demo.modules.spider.controller;


import com.alibaba.excel.EasyExcel;
import com.example.demo.common.util.ExcelUtil;
import com.example.demo.common.util.Listener;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.service.ITbSampleService;
import com.example.demo.modules.spider.service.IViewSampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.common.web.base.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("view-sample")
@Api(tags = "蜘蛛序列视图接口")
public class ViewSampleController extends BaseController {

    @Resource
    IViewSampleService iViewSampleService;

    @Resource
    ITbSampleService iTbSampleService;

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

    @GetMapping("get/{id}")
    @ApiOperation("获取单个基因视图数据")
    public Result get(@PathVariable String id){
        return success(iViewSampleService.getById(id));
    }

    @PostMapping("exportExcel")
    @ApiOperation("导出 Excel ")
    public void getExcel(HttpServletResponse response,@RequestBody List<ViewSample> viewSampleList) throws IllegalAccessException, IOException,
            InstantiationException {
        List<ViewSample> list = viewSampleList;
        if(viewSampleList.isEmpty())
            list = iViewSampleService.list();
        ExcelUtil.download(response,ViewSample.class,list);
    }

    @PostMapping("importExcel")
    @ApiOperation("大量数据导入Excel（暂时不用）")
    public Result importExcel(@RequestParam(value = "excelFile") MultipartFile file,HttpServletRequest request) throws IOException{
        EasyExcel.read(file.getInputStream(), TbSample.class, new Listener(iTbSampleService,request)).sheet().doRead();
        return success();
    }

}
