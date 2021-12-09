package com.example.demo.common.util;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.web.exception.token.TokenValidationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.util.Date;

/**
 * Token 工具类
 */
public class TokenUtil {

    /**
     * 创建 Token
     *
     * @param userId 用户编号
     * @param username 用户账号
     */
    public static String create(String userId,String username){
        return  Jwts.builder()
                .setId(userId)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer(Constant.Token.ISSUER)
                .signWith(SignatureAlgorithm.HS512, Constant.Token.SECRET)
                .compact();
    }

    /**
     * 解析 Token
     *
     * @param token Token
     */
    public static void parse(String token) {
        try {
            Jwts.parser().setSigningKey(Constant.Token.SECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            throw new TokenValidationException("token validation failure");
        }
    }
}
