package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.modules.spider.entity.TbSpider;
import com.example.demo.modules.spider.mapper.TbSpiderMapper;
import com.example.demo.modules.spider.service.ITbSpiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Service
public class TbSpiderServiceImpl extends ServiceImpl<TbSpiderMapper, TbSpider> implements ITbSpiderService {


    /**
     * 查 询 spider 信息
     *
     * @param name
     * @return
     */
    @Override
    public TbSpider getSpider(String name) {
        QueryWrapper<TbSpider> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name).last("limit 1");

        return super.getOne(queryWrapper);
    }
}
