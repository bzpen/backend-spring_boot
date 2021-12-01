package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@ResponseBody
@Controller
@RequestMapping("/sample")
@Api(tags = "基因序列管理接口")
public class SampleController {
}
