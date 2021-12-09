package com.example.demo.modules.spider.service;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.Sample;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
public interface SampleService {

    /**
     * 获取单个序列
     * @param sampleId
     * @return
     */
    Result get(Integer sampleId);

    /**
     * 获取所有序列
     * @return
     */
    Result gets();

    /**
     * 删除单个序列
     * @param sampleId
     * @return
     */
    Result del(Integer sampleId);

    /**
     * 更改序列信息
     * @param sample
     * @return
     */
    Result update(Sample sample);

    /**
     * 增加序列信息
     * @param sample
     * @return
     */
    Result add(Sample sample);
}
