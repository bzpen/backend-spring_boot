package com.example.demo.modules.spider.service;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.entity.TbSpider;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.param.SpiderImgPath;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;

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

    /**
     * 新 增 蜘 蛛 种 类
     *
     * @param tbSpider
     * @return
     */
    Result add(TbSpider tbSpider);


    /**
     * 插 入 蜘 蛛 图 片
     *
     * @param file
     * @param file_path
     * @return
     */
    Result add(MultipartFile file, String file_path);

    /**
     * 获 取 蜘 蛛 种 类 详 情
     *
     * @param id
     * @return
     */
    SpiderImgPath getSpiderImage(Serializable id);


    /**
     * 删 除 图 片
     *
     * @param filePath
     * @return
     */
    Boolean delImage(String filePath);
}
