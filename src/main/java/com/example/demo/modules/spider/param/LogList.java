package com.example.demo.modules.spider.param;

import lombok.Data;
import org.apache.ibatis.javassist.expr.NewArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/27
 */
@Data
public class LogList {

    /**
     * 用户登录记录
     */
    List<Integer> user;

    /**
     * 管理员登录记录
     */
    List<Integer> admin;


    public LogList(){
        this.user = new ArrayList<>();

        this.admin = new ArrayList<>();
    }

}
