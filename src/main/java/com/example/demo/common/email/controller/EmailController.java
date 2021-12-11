package com.example.demo.common.email.controller;

import com.example.demo.common.email.entity.Email;
import com.example.demo.common.email.service.EmailCodeService;
import com.example.demo.common.web.domain.Result;
import io.swagger.annotations.Api;
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
    public Result getEmailCode(Email email){
        return Result.success(emailCodeService.createCode(email));
    }
}
