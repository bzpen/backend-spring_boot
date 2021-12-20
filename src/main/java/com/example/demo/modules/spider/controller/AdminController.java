package com.example.demo.modules.spider.controller;

import com.example.demo.modules.spider.entity.Admin;
import com.example.demo.modules.spider.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */

@ResponseBody
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public HashMap<String, Object> admin_Login(Admin admin){
        return adminService.login_Admin(admin);
    }

    /**
     * 管理员添加
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public HashMap<String,Object> add_Admin(Admin admin){
        return adminService.add_Admin(admin);
    }

    /**
     * 获取管理员列表
     * @return
     */
    @PostMapping("/getAdmins")
    public HashMap<String,Object> admin_List(){
        return adminService.admin_List();
    }

    /**
     * 删除管理员
     * @return
     */
    @PostMapping("/delete_Admin")
    public HashMap<String,Object> delete_Admin(Admin admin){
        return adminService.delete_Admin(admin);
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @PostMapping("/token")
    public HashMap<String,Object> token_Check(String token){
        return adminService.token_Check(token);
    }
}
