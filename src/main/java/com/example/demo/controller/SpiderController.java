package com.example.demo.controller;

import com.example.demo.core.response.Result;
import com.example.demo.entity.Spider;
import com.example.demo.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@RequestMapping("/spider")
@Controller
@ResponseBody
public class SpiderController {

    @Autowired
    SpiderService spiderService;

    /**
     * 获取spider列表
     * @return
     */
    @PostMapping("/getAll")
    public Result getAll(){
        return spiderService.gets();
    }

    /**
     * 获取单条记录
     * @param spider
     * @return
     */
    @PostMapping("/get")
    public Result get(Spider spider){
        return spiderService.get(spider);
    }

    /**
     * 更新一条记录
     * @param spider
     * @return
     */
    @PostMapping("/update")
    public Result update(Spider spider){
        return spiderService.update(spider);
    }

    /**
     * 插入一条新记录
     * @param spider
     * @return
     */
    @PostMapping("/insert")
    public Result insert(Spider spider, List<MultipartFile> files){
        return spiderService.insert(spider,files);
    }

    /**
     * 删除一条记录
     * @param spider
     * @return
     */
    public Result delete(Spider spider){
        return spiderService.delete(spider);
    }


}
