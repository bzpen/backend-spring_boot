package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
public interface UserService {
    //获取用户列表
    HashMap<String,Object> user_List();

    //    删除用户
    HashMap<String,Object> delete_User(User user);

    //    升级用户权限
    HashMap<String,Object> up_User(User user);

    //    降低用户权限
    HashMap<String,Object> down_User(User user);
}
