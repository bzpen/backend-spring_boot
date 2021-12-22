package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbUser;
import com.example.demo.modules.spider.service.ITbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */

@RestController
@RequestMapping("/user")
@Api(tags = "用户控制器")
public class TbUserController {

    @Resource
    ITbUserService ITbUserService;

    /**
     * 用户注册
     * @param tbUser
     * @return
     */
    @PostMapping("add")
    @ApiOperation("用户注册接口")
    public Result save(TbUser tbUser){
        return Result.success(ITbUserService.save(tbUser));
    }

    /**
     * 用户名验证
     *
     * @param username
     * @return
     */
    @GetMapping("check")
    @ApiOperation("检查用户名是否存在")
    public Result check(String username){
        return ITbUserService.check_username(username);
    }

    @GetMapping("del/{id}")
    @ApiOperation("删除单个用户")
    public Result del(@PathVariable String id){
        return Result.decide(ITbUserService.removeById(id));
    }

    @PostMapping("delList")
    @ApiOperation("批量删除用户")
    public Result delList(@RequestBody List<TbUser> tbUserList){
        return Result.decide(ITbUserService.delList(tbUserList));
    }
}
