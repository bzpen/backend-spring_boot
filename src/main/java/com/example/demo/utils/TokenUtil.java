package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("adminNumber", admin.getAdmin_number())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));

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
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("adminNumber: " + jwt.getClaim("adminNumber").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
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
            if(verify(token)){
                Admin admin=new Admin();
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
                DecodedJWT jwt = verifier.verify(token);
                admin.setAdmin_number(jwt.getClaim("adminNumber").asString());
                return admin;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
