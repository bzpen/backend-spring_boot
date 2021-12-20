package com.example.demo.modules.spider.controller;


import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.User;
import com.example.demo.modules.spider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Resource
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
    @PostMapping("/deleteUser")
    public HashMap<String,Object> delete_User(User user){
        return userService.delete_User(user);
    }


    @PostMapping("/deleteUsers")
    public Result delete_Users(@RequestParam List<User> users){
        return userService.delete_Users(users);
    }
    /**
     * 升级用户权限
     * @param user
     * @return
     */
    @PostMapping("/up_User")
    public HashMap<String,Object> up_User(User user){
        return userService.up_User(user);
    }

    /**
     * 降低用户权限
     * @param user
     * @return
     */
    @PostMapping("/down_User")
    public HashMap<String,Object> down_User(User user){
        return userService.down_User(user);
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("add")
    @ApiOperation("用户注册接口")
    public Result save(User user){
        return Result.success(userService.save(user));
    }

    /**
     * 用户名验证
     *
     * @param username
     * @return
     */
    @GetMapping("check")
    @ApiOperation("检查用户名是否存在")
    public Result check(String username){
        return userService.check_username(username);
    }
}
