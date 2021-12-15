package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.mapper.TbSampleMapper;
import com.example.demo.modules.spider.service.ITbSampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Service
public class TbSampleServiceImpl extends ServiceImpl<TbSampleMapper, TbSample> implements ITbSampleService {
    /**
     * 序 列 检 测
     *
     * @param list
     * @return
     */
    @Override
    public boolean checkList(String list) {
        QueryWrapper<TbSample> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("list",list)
                .last("limit 1");

        TbSample sample = super.getOne(queryWrapper);
        if(sample == null)
            return false;
        return true;
    }

    /**
     * 序列编号检测
     *
     * @param number
     * @return
     */
    @Override
    public boolean checkNumber(String number) {
        QueryWrapper<TbSample> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("number",number)
                .last("limit 1");

        TbSample sample = super.getOne(queryWrapper);

        if(sample == null)
            return false;
        return true;
    }

    /**
     * 新 增 蜘 蛛 序 列
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(TbSample entity) {
        TbSample tbSample=TbSample.builder()
                .id(null)
                .number(entity.getNumber())
                .spider(entity.getSpider())
                .genetic(entity.getGenetic())
                .locations(entity.getLocations())
                .jDu(entity.getJDu())
                .wDu(entity.getWDu())
                .list(entity.getList())
                .length(entity.getList().length())
                .remark(entity.getRemark())
                .build();
        return super.save(tbSample);
    }
}
