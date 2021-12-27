package com.example.demo.modules.spider.service;

import com.example.demo.modules.spider.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 获取用户登录记录
     *
     * @return
     */
    List<Log> getLoginUser();


    /**
     * 获取管理员登录记录
     *
     * @return
     */
    List<Log> getLoginAdmin();

}
