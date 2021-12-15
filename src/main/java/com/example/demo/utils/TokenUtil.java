package com.example.demo.utils;


import com.example.demo.modules.spider.entity.Admin;

import java.util.Date;

public class TokenUtil {

    private static final long EXPIRE_TIME = 15 * 24 * 60 * 60 * 1000;
    private static final String TOKEN_SECRET = "kaitoKuroba";  //密钥盐

    /**
     * 签名生成
     *
     * @param admin
     * @return
     */
    public static String sign(Admin admin) {
        String token = null;
        try {
          return null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名验证
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
          return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * 签名解读用户名
     *
     * @param token
     * @return
     */
    public static Admin tokenAdmin(String token) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
