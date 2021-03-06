package com.example.demo.common.constant;

import com.example.demo.common.config.SwaggerConfig;

/**
 * 常量集中
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public interface Constant {

    /**
     * Spring Security Constant
     */
    interface Security {

        /**
         * 开放接口列表
         */
        String[] openApi = {
                //临时开放
//                "/view-sample/**",
                //email
                "/email/**",
                "/user/**",
                //security
                "/admin/login",
                "/api/login",
                "/api/logout",
                "/login",
                "/user/email",
                //主页
                "/",
                "/index**",
                //SwaggerConfig
                "/swagger-ui.html",
                "/v2/api-docs",
                "/v3/api-docs",
                "/webjars/springfox-swagger-ui/**",
                "/swagger-resources",
                "/swagger-resources/configuration/**",
                "/swagger-ui/**",
                "/swagger-ui/",
                "/admin/**",
                "/static/**/**/**",
                "/static/**/**",
                "/spider/image",
        };

        /**
         * 默认的登陆接口
         */
        String LOGIN_URL = "/api/login";

        /**
         * 默认的注销接口
         */
        String LOGOUT_URL = "/api/logout";

        /**
         * Token 过期时间
         */
        long TOKEN_EXPIRATION = 1000 * 60 * 30;

        /**
         * 验证码 过期时间
         */
        long CODE_EXPIRATION = 1 * 60 * 5;
    }

    /**
     * Controller Constant
     */
    interface Controller {
        /**
         * 主页消息
         */
        String INDEX_MSG = "Graduation design backend is running... <a href='/swagger-ui/'>Docs</a>";
    }

    /**
     * System Constant
     */
    interface System {

        /**
         * 项目编码
         */
        String UTF8 = "UTF-8";
    }

    /**
     * Token Constant
     */
    interface Token {

        /**
         * Access Token 密钥
         */
        String SECRET = "KAITO-KUROBO-SECRET";

        /**
         * Access Token 前缀
         */
        String TOKEN_PREFIX = "Bearer ";

        /**
         * Access Token 发布者
         */
        String ISSUER = "Kaito-Kurobo";

        /**
         * Http Header Token 请求头
         */
        String TOKEN_HEADER =  "token";

        /**
         * Token 存储前缀
         */
        String TOKEN_NAME_PREFIX = "TOKEN-";
    }

    interface Email{

        /**
         * Code 前缀
         */
        String CODE_NAME_PREFIX = "CODE-";
        /**
         * 邮件标题
         */
        String EMAIL_HEADER = "蛛毒数据网站系统";

        /**
         * code 前文本
         */
        String EMAIL_FONT = "【蛛毒数据库系统】您的邮箱验证码为：";

        /**
         * code 后文本
         */
        String EMAIL_REAR = "，有效时间为5分钟(若非本人操作，可忽略该条邮件)";
    }

    interface Log{

        /**
         * 登 录 角 色
         *
         */
        String ROLE_ADMIN = "管理员";

        String ROLE_USER = "用户";

        /**
         * 操作
         *
         */
        String ACTION_LOGIN = "登录";

        String ACTION_LOGOUT = "退出登录";

        String ACTION_DEL = "删除数据";

        String ACTION_ADD = "添加数据";

        String ACTION_UPDATE = "更改数据";

    }

    interface Img{

        /**
         *  数 据 库 图 片 存 放 地 址
         */
//        String REAL_IMG_PATH = "D:/Vue毕设项目/毕设后台/img/";
        String REAL_IMG_PATH = "/root/java/java_backend/img/";

        /**
         * 图 片 映 射 地 址
         */
        String VIRTUAL_IMG_PATH = "/static/";

        /**
         * 蜘 蛛 图 片
         */
        String IMG_SPIDER = "spider_photo/";

        /**
         *
         */
        String IMG_USER = "user";

        String IMG_ADMIN = "admin";

    }

}
