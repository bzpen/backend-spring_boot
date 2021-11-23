package com.example.demo.controller;


import com.example.demo.core.response.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取用户信息列表
     * @return
     */
    @PostMapping("/getUsers")
    public HashMap<String,Object> user_List(){
        return userService.user_List();
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("/deleteUser")
    public HashMap<String,Object> delete_User(User user){
        return userService.delete_User(user);
    }


    @PostMapping("/deleteUsers")
    public Result delete_Users(List<User> users){
        return userService.delete_Users(users);
    }
    /**
     * 升级用户权限
     * @param user
     * @return
     */
    @RequestMapping("/up_User")
    public HashMap<String,Object> up_User(User user){
        return userService.up_User(user);
    }

    /**
     * 降低用户权限
     * @param user
     * @return
     */
    @RequestMapping("/down_User")
    public HashMap<String,Object> down_User(User user){
        return userService.down_User(user);
    }
}
