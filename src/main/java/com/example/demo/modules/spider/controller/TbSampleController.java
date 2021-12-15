package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.base.coordinates.CoordinatesService;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.Sample;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.service.ITbSampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;
import java.io.IOException;

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

    @PostMapping("add")
    @ApiOperation("蜘蛛序列添加")
    public Result add(TbSample sample){
        return Result.success(iTbSampleService.save(sample));
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
}
