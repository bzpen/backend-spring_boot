package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
@Mapper
public interface UserMapper {

//    获取用户列表
    List<User> user_List();

//    删除用户
    int delete_User(User user);

//    升级用户权限
    int up_User(User user);

//    降低用户权限
    int down_User(User user);

//    查询用户信息
    User get_User(User user);

}
