package com.example.demo.mapper;


import com.example.demo.entity.Admin;
import com.example.demo.entity.son.Role_Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface AdminMapper {
//    查询管理员信息
    Admin login_Admin(Admin admin);

//    添加
    int add_Admin(Admin admin);

//    获取管理员列表
    List<Role_Admin> admin_List();

//    删除管理员
    int delete_Admin(Admin admin);

}
