package com.example.demo.modules.spider.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
public interface ITbUserService extends IService<TbUser> {

    /**
     * 升级用户权限
     * @param id
     * @return
     */
    boolean up(String id);

    /**
     * 降低用户权限
     * @param id
     * @return
     */
    boolean down(String id);

    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    Result check_username(String username);

    /**
     * 批 量 删 除 用 户
     *
     * @param tbUserList
     * @return
     */
    boolean delList(List<TbUser> tbUserList);
}
