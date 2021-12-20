package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbAdmin;
import com.example.demo.modules.spider.service.ITbAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/tb-admin")
@Api(tags = "管理员操作接口")
public class TbAdminController extends BaseController {

    @Resource
    ITbAdminService iTbAdminService;

    @ApiOperation("管理员添加")
    @PostMapping("add")
    public Result add(TbAdmin tbAdmin){
        return decide(iTbAdminService.save(tbAdmin));
    }

    @ApiOperation("单个管理员删除")
    @GetMapping("del/{id}")
    public Result del(@PathVariable String id){
        return decide(iTbAdminService.removeById(id));
    }

    @ApiOperation("批量删除")
    @PostMapping("delList")
    public Result delList(@RequestBody List<Integer> list){
        return decide(iTbAdminService.delList(list));
    }


    @ApiOperation("管理员信息更改")
    @PostMapping("update")
    public Result update(TbAdmin tbAdmin){
        return decide(iTbAdminService.updateById(tbAdmin));
    }

}
