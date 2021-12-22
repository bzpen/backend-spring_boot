package com.example.demo.modules.sys.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.sys.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/tb-role")
@Api(tags = "权限操作")
public class SysRoleController extends BaseController {

    @Resource
    SysRoleService sysRoleService;

    @ApiOperation("用户权限返回")
    @GetMapping("gets")
    public Result gets(){
        return success(sysRoleService.list());
    }

}
