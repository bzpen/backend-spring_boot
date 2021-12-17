package com.example.demo.modules.spider.service;

import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.entity.TbSpider;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
public interface ITbSpiderService extends IService<TbSpider> {


    /**
     * 根据 spider name获取spider信息
     *
     * @param name
     * @return
     */
    TbSpider getSpider(String name);
}
