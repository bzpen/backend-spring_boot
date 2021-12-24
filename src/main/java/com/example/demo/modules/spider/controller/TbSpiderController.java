package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSpider;
import com.example.demo.modules.spider.service.ITbSpiderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.web.base.BaseController;

import javax.annotation.Resource;
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
@RequestMapping("/tb-spider")
@Api(tags = "蜘蛛种类接口")
public class TbSpiderController extends BaseController {

    @Resource
    ITbSpiderService iTbSpiderService;

    @GetMapping("list")
    @ApiOperation("获取蜘蛛种类")
    public Result list(){
        List<TbSpider> list = iTbSpiderService.list();
        return success(list);
    }

    @ApiOperation("获取单个蜘蛛种类数据")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id){
        return success(iTbSpiderService.getById(id));
    }

}
