package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.User;
import com.example.demo.modules.spider.mapper.UserMapper;
import com.example.demo.modules.spider.service.UserService;
import com.example.demo.modules.sys.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-11-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    SysUserService sysUserService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private HashMap<String,Object> result=new HashMap<>();

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public HashMap<String, Object> user_List() {
        String state="";
        List<User> users=null;
        try {
            result.clear();
            users = userMapper.user_List();
            if(users != null ){
                state = "true";
            }else{
                state = "false";
            }
        } catch (Exception e) {
            state = "404";

        }
        result.put("state",state);
        result.put("users",users);
        return result;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @Override
    public HashMap<String, Object> delete_User(User user) {
        String state="",msg="";
        try {
            result.clear();
            int res = userMapper.delete_User(user);
            if(res == 1 ){
                state = "true";
                msg="删除成功！";
            }else{
                state = "false";
                msg="删除失败！";
            }
        } catch (Exception e) {
            state = "404";
            msg="非常抱歉，系统异常，请重试！";
        }
        result.put("state",state);
        result.put("msg",msg);
        return result;
    }

    /**
     * 升级权限
     * @param user
     * @return
     */
    @Override
    public HashMap<String, Object> up_User(User user) {
        String state="",msg="";
        try {
            result.clear();
            user = userMapper.get_User(user);
            if(user.getRoleId()==1){
                state="false";
                msg="用户已是最高权限!";
            }else{
                int res = userMapper.up_User(user);
                if(res == 1 ){
                    state = "true";
                    msg="升级权限成功！";
                }else{
                    state = "false";
                    msg="升级权限失败！";
                }
            }
        } catch (Exception e) {
            state = "404";
            msg="非常抱歉，系统异常，请重试！";
        }
        result.put("state",state);
        result.put("msg",msg);
        return result;
    }

    /**
     * 降低权限
     * @param user
     * @return
     */
    @Override
    public HashMap<String, Object> down_User(User user) {
        String state="",msg="";
        try {
            result.clear();
            user = userMapper.get_User(user);
            if(user.getRoleId()==2){
                state="false";
                msg="用户已无法降低权限!";
            }else{
                int res = userMapper.down_User(user);
                if(res == 1 ){
                    state = "true";
                    msg="降低权限成功！";
                }else{
                    state = "false";
                    msg="降低权限失败！";
                }
            }
        } catch (Exception e) {
            state = "404";
            msg="非常抱歉，系统异常，请重试！";
        }
        result.put("state",state);
        result.put("msg",msg);
        return result;
    }

    @Override
    public Result delete_Users(List<User> users) {
        try{
            for(User user:users){
                int result=userMapper.delete_User(user);
                if(result != 1){
                    return Result.failure("批量删除失败，请重试！");
                }
            }
            return Result.success("批量删除成功！");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("数据获取失败！");
    }

    /**
     * 注 册 新 用 户
     * @param entity
     * @return
     */
    @Override
    public boolean save(User entity) {
        User user= User.builder()
                .id(null)
                .deleted(false)
                .locked(false)
                .enable(true)
                .roleId(2)
                .password(bCryptPasswordEncoder.encode(entity.getPassword()))
                .email(entity.getEmail())
                .username(entity.getUsername())
                .userPhoto("/root/java/java_backend/user/head.jpg")
                .build();
        return super.save(user);
    }

    @Override
    public Result check_username(String username) {
        if(sysUserService.selectByUsername(username)!=null)
            return Result.success("用户名已注册");
        return Result.failure("用户名未注册");
    }
}
