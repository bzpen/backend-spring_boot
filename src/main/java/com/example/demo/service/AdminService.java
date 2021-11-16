package com.example.demo.service;


import com.example.demo.entity.Admin;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
public interface AdminService {

    //登录
    HashMap<String,Object> login_Admin(Admin admin);

    //添加管理员
    HashMap<String,Object> add_Admin(Admin admin);

    //    获取管理员列表
    HashMap<String,Object> admin_List();

    //    删除管理员
    HashMap<String,Object> delete_Admin(Admin admin);

    //    token验证
    HashMap<String,Object> token_Check(String token);
}
