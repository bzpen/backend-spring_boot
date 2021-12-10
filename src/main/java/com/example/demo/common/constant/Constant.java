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
                //security
                "/admin/login",
                "/api/login",
                "/api/logout",
                "/login",
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
                "/admin/**", "/static/**", "/spider/image",
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
    }

    /**
     * Controller Constant
     */
    interface Controller {
        /**
         * 主页消息
         */
        String INDEX_MSG = "Tea traceability backend is running... <a href='/swagger-ui/'>Docs</a>";
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
        String SECRET = "YOUTH-LAB-SECRET";

        /**
         * Access Token 前缀
         */
        String TOKEN_PREFIX = "Bearer ";

        /**
         * Access Token 发布者
         */
        String ISSUER = "Youth-Lab";

        /**
         * Http Header Token 请求头
         */
        String TOKEN_HEADER =  "token";

        /**
         * Token 存储前缀
         */
        String TOKEN_NAME_PREFIX = "TOKEN-";
    }
}
