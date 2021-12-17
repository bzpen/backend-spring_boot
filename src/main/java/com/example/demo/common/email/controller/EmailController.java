package com.example.demo.common.email.controller;

import com.example.demo.common.email.entity.Email;
import com.example.demo.common.email.service.EmailCodeService;
import com.example.demo.common.web.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
@RestController
@RequestMapping("email")
@Api(tags = "邮箱发送接口")
public class EmailController {

    @Resource
    EmailCodeService emailCodeService;

    @GetMapping("get")
    @ApiOperation("获取邮箱验证码")
    public Result getEmailCode(Email email){
        emailCodeService.createCode(email);
        return Result.success("验证发送成功，请注意查收！");
    }

    @GetMapping("check")
    @ApiOperation("邮箱检测")
    public Result check(Email email){
        return emailCodeService.check(email);
    }


    @GetMapping("checkCode")
    @ApiOperation("邮箱验证码检测")
    public Result checkCode(Email email){
        return emailCodeService.checkCode(email);
    }
}
