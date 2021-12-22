package com.example.demo.modules.spider.controller;


import com.example.demo.common.util.FileUploadUtil;
import com.example.demo.common.web.base.coordinates.CoordinatesService;
import com.example.demo.common.web.base.echarts.ECharsService;
import com.example.demo.common.web.base.echarts.MapECharts;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.service.ITbSampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.common.web.base.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@RestController
@RequestMapping("/tb-sample")
@Api(tags = "蜘蛛序列操作接口")
public class TbSampleController extends BaseController {

    @Resource
    ITbSampleService iTbSampleService;

    @Resource
    ECharsService eCharsService;


    @PostMapping("add")
    @ApiOperation("蜘蛛序列添加")
    public Result add(TbSample sample, HttpServletRequest request) throws IOException{
        return iTbSampleService.add(sample,request);
    }


    @PostMapping("adds")
    @ApiOperation("excel数据批量上传")
    public Result adds(MultipartFile file,HttpServletRequest request) throws Exception{
        if(file.isEmpty())
            return failure("为获取到文件");
        List<ViewSample> list = FileUploadUtil.excelUpload(file.getInputStream());

        return success(iTbSampleService.adds(list,request));
    }

    @GetMapping("checkNumber")
    @ApiOperation("序列编号检测")
    public Result checkNumber(String number){
        return decide(iTbSampleService.checkNumber(number));
    }


    @GetMapping("checkList")
    @ApiOperation("蜘蛛序列检测")
    public Result checkList(String list){
        return decide(iTbSampleService.checkList(list));
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据id获取基因序列信息")
    public Result get(@PathVariable String id){
        return success(iTbSampleService.getById(id));
    }


    @GetMapping("getCoordinates")
    @ApiOperation("根据地点名获取经纬度")
    public Result getCoordinates(String locations) throws IOException {
        return success(CoordinatesService.getCoordinate(locations));
    }

    @GetMapping("getMap")
    @ApiOperation("获取地图数据")
    public Result getMapEChars(){
        List<MapECharts> list=eCharsService.getEChars();
        return success(list);
    }

    @ApiOperation("删除单个序列")
    @GetMapping("del/{id}")
    public Result del(@PathVariable String id){
        return decide(iTbSampleService.removeById(id));
    }


    @ApiOperation("批量删除")
    @PostMapping("delList")
    public Result delList(@RequestBody List<ViewSample> list){
        return decide(iTbSampleService.delList(list));
    }
}
