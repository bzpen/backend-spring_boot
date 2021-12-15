package com.example.demo.modules.spider.service;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.utils.FileUploadUtil;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
public interface ITbSampleService extends IService<TbSample> {

    /**
     * 检测序列编号是否重复
     *
     * @param number
     * @return
     */
    boolean checkNumber(String number);

    /**
     * 序列检测
     *
     * @param list
     * @return
     */
    boolean checkList(String list);
}
