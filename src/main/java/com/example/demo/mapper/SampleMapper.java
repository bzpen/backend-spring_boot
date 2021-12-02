package com.example.demo.mapper;

import com.example.demo.entity.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@Mapper
public interface SampleMapper {

    /**
     * 获取单个序列
     * @param sampleId
     * @return
     */
    Sample get(Integer sampleId);

    /**
     * 获取所有序列
     * @return
     */
    List<Sample> gets();

    /**
     * 删除单个序列
     * @param sampleId
     * @return
     */
    Integer del(Integer sampleId);

    /**
     * 更改序列信息
     * @param sample
     * @return
     */
    Integer update(Sample sample);

    /**
     * 增加序列信息
     * @param sample
     * @return
     */
    Integer add(Sample sample);

}
