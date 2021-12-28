package com.example.demo.modules.spider.service;

import com.example.demo.modules.spider.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.param.LogList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-21
 */
public interface ILogService extends IService<Log> {


    /**
     * 获取登录记录
     *
     * @return
     */
     LogList getLogData();

}
