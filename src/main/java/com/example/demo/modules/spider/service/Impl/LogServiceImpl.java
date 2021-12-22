package com.example.demo.modules.spider.service.Impl;

import com.example.demo.modules.spider.entity.Log;
import com.example.demo.modules.spider.mapper.LogMapper;
import com.example.demo.modules.spider.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public boolean save(Log entity) {
        entity.setDate(LocalDateTime.now());
        return super.save(entity);
    }
}
