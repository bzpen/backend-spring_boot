package com.example.demo.modules.spider.mapper;

import com.example.demo.modules.spider.entity.TbSample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.spider.param.MapSample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Mapper
public interface TbSampleMapper extends BaseMapper<TbSample> {

    /**
     * 筛 选 去 除 重 复 地 点
     *
     * @return
     */
    List<MapSample> getMapList();

}
