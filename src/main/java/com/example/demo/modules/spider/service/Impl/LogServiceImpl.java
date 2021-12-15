package com.example.demo.modules.spider.service.Impl;

import com.example.demo.modules.spider.entity.Log;
import com.example.demo.modules.spider.mapper.LogMapper;
import com.example.demo.modules.spider.service.ILogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
