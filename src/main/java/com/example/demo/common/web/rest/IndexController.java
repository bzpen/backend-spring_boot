package com.example.demo.common.web.rest;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.web.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制器
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@RestController
@Api(tags = "首页控制器")
public class IndexController {

    @GetMapping({"", "index*"})
    @ApiOperation("主页")
    public String index() {
        return Constant.Controller.INDEX_MSG;
    }

    @GetMapping({"token"})
    @ApiOperation("主页")
    public Result token() {
        return Result.success();
    }
}
