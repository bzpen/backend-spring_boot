package com.example.demo.service;

import com.example.demo.core.response.Result;
import com.example.demo.entity.Spider;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
public interface SpiderService {
    /**
     * 获取单条spider数据
     * @param spider
     * @return
     */
    Result get(Spider spider);
    /**
     * 获取spider列表并返回
     * @return
     */
    Result gets();

    /**
     * 插入新记录
     * @param spider
     * @return
     */
    Result insert(Spider spider, MultipartFile file);

    /**
     * 更新一条记录
     * @param spider
     * @return
     */
    Result update(Spider spider);

    /**
     * 删除一条记录
     * @param spider
     * @return
     */
    Result delete(Spider spider);

    /**
     * 删除多条记录
     * @param spiderList
     * @return
     */
    Result deleteList(List<Spider> spiderList);
}
