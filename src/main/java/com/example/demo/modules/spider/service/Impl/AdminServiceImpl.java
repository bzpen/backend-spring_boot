package com.example.demo.modules.spider.service.Impl;

import com.example.demo.modules.spider.entity.Admin;
import com.example.demo.modules.spider.entity.view.Role_Admin;
import com.example.demo.modules.spider.mapper.AdminMapper;
import com.example.demo.modules.spider.service.AdminService;
import com.example.demo.utils.MD5Utils;
import com.example.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    private HashMap<String,Object> result=new HashMap<>();

    /**
     * 验证token
     * @param token
     * @return
     */
    @Override
    public HashMap<String, Object> token_Check(String token) {
        String msg="",state="";
        try {
            result.clear();
            System.out.println(token);
            if(!token.equals("null")){
                Admin admin = TokenUtil.tokenAdmin(token);
                Admin result = adminMapper.login_Admin(admin);
                if(result!=null ){
                    state = "true";
                    msg = result.getName() + ",检测到你已登录！";
                    token = TokenUtil.sign(admin);
                }else{
                    state = "false";
                    msg="账号以不存在，请重试！";
                }
            }else{
                state = "false";
                msg="请先登录！";
            }
        } catch (Exception e) {
            System.out.println(e);
            state = "404";
            msg="非常抱歉，系统异常，请重试！";
        }
        result.put("state",state);
        result.put("msg",msg);
        result.put("token",token);
        return result;
    }

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Override
    public HashMap<String,Object> login_Admin(Admin admin) {
        String msg="",state="",token="";
        try {
            result.clear();
            Admin result = adminMapper.login_Admin(admin);
            if(result!=null ){
                admin.setPassword(MD5Utils.code(admin.getPassword()));
                if(admin.getPassword().equalsIgnoreCase(result.getPassword())){
                    state = "true";
                    msg = result.getName() + "欢迎登录！";
                    token = TokenUtil.sign(admin);
                }else{
                    state = "false";
                    msg="密码输入错误，请重试！";
                }
            }else{
                state = "false";
                msg="账号不存在，请重试！";
            }
        } catch (Exception e) {
            System.out.println(e);
            state = "404";
            msg="非常抱歉，系统异常，请重试！";
        }
        result.put("state",state);
        result.put("msg",msg);
        result.put("token",token);
        return result;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public HashMap<String, Object> add_Admin(Admin admin) {
        String msg="",state="";
        try {
            Admin admin1 = adminMapper.login_Admin(admin);
            if(admin1 == null){
                admin.setPassword(MD5Utils.code(admin.getPassword()));
                int result = adminMapper.add_Admin(admin);
                if(result == 1 ){
                    state = "true";
                    msg = "添加成功！";
                }else{
                    state = "false";
                    msg="添加失败，请重试！";
                }
            }else{
                state = "false";
                msg="管理员账号已存在！";
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
     * 获取管理员列表
     * @param
     * @return
     */
    @Override
    public HashMap<String, Object> admin_List() {
        String state="";
        List<Role_Admin> admins=null;
        try {
            result.clear();
            admins = adminMapper.admin_List();
            if(admins != null ){
                state = "true";
            }else{
                state = "false";
            }
        } catch (Exception e) {
            state = "404";

        }
        result.put("state",state);
        result.put("admins",admins);
        return result;
    }
    /**
     * 删除管理员
     * @param admin
     * @return
     */
    @Override
    public HashMap<String, Object> delete_Admin(Admin admin) {
        String state="",msg="";
        try {
            result.clear();
            int res = adminMapper.delete_Admin(admin);
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

}
