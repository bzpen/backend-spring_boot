package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.modules.spider.entity.Log;
import com.example.demo.modules.spider.mapper.LogMapper;
import com.example.demo.modules.spider.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-21
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Resource
    LogMapper logMapper;


    @Override
    public boolean save(Log entity) {
        entity.setDate(LocalDateTime.now());
        return super.save(entity);
    }


    @Override
    public List<Log> getLoginUser() {
        return logMapper.getLoginUser();
    }

    @Override
    public List<Log> getLoginAdmin() {
        return logMapper.getLoginAdmin();
    }
}
