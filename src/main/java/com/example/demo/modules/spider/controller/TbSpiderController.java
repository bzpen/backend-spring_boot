package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSpider;
import com.example.demo.modules.spider.service.ITbSpiderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.index.GeoIndexed;
import org.springframework.web.bind.annotation.*;

import com.example.demo.common.web.base.BaseController;
import org.springframework.web.multipart.MultipartFile;

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
        return success(iTbSpiderService.getSpiderImage(id));
    }

    /**
     * 插入一条新记录
     * @param spider
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加记录")
    public Result insert(TbSpider spider){
        return iTbSpiderService.add(spider);
    }

    /**
     * 插入图片
     * @param file
     * @param file_path
     * @return
     */
    @PostMapping("/image")
    @ApiOperation("图片插入")
    public Result insertPhoto(MultipartFile file, String file_path){
        System.out.println(file_path);
        return iTbSpiderService.add(file,file_path);
    }

    @ApiOperation("删除图片")
    @GetMapping("/delImage")
    public Result delImage(String filePath){
        System.out.println(filePath);
        return decide(iTbSpiderService.delImage(filePath));
    }

    /**
     * 数 据 删 除
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    @ApiOperation("数据删除")
    public Result del(@PathVariable String id){
        return success(iTbSpiderService.removeById(id));
    }

}
