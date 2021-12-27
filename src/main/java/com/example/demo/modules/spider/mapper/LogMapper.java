package com.example.demo.modules.spider.mapper;

import com.example.demo.modules.spider.entity.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-21
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

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
