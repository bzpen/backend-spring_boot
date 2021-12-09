package com.example.demo.modules.spider.controller;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.Sample;
import com.example.demo.modules.spider.service.SampleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    SampleService sampleService;

    @GetMapping("/get")
    public Result get(Integer sampleId){
        return sampleService.get(sampleId);
    }

    @GetMapping("/gets")
    public Result gets(){
        return sampleService.gets();
    }

    @GetMapping("/del")
    public Result del(Integer sampleId){
        return sampleService.del(sampleId);
    }

    @PostMapping("/update")
    public Result update(Sample sample){
        return sampleService.update(sample);
    }

    @PostMapping("/add")
    public Result add(Sample sample){
        return sampleService.add(sample);
    }
}
