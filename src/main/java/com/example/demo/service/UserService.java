package com.example.demo.service;


import com.example.demo.core.response.Result;
import com.example.demo.entity.User;

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
public interface UserService {
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


}
