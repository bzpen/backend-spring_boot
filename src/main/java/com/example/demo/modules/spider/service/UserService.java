package com.example.demo.modules.spider.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
public interface UserService extends IService<User> {

    /**
     * 获取用户列表
     * @return
     */
    HashMap<String,Object> user_List();

    /**
     * 删除用户
     * @param user
     * @return
     */
    HashMap<String,Object> delete_User(User user);

    /**
     * 批量删除用户
     * @param users
     * @return
     */
    Result delete_Users(List<User> users);

    /**
     * 升级用户权限
     * @param user
     * @return
     */
    HashMap<String,Object> up_User(User user);

    /**
     * 降低用户权限
     * @param user
     * @return
     */
    HashMap<String,Object> down_User(User user);

    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    Result check_username(String username);
}
