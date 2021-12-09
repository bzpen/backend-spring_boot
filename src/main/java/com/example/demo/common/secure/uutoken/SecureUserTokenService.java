package com.example.demo.common.secure.uutoken;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.util.TokenUtil;
import com.example.demo.common.web.exception.token.TokenException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Security User Token 操作服务
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Component
public class SecureUserTokenService {

    @Resource
    private RedisTemplate<String,SecureUserToken> redisTemplate;

    /**
     * 创建 token
     */
    public SecureUserToken createToken(SecureUser secureUser){
        SecureUserToken userToken=new SecureUserToken();
        userToken.setToken(TokenUtil.create(secureUser.getUserId(),secureUser.getUsername()));
        userToken.setSecureUser(secureUser);
        return userToken;
    }

    /**
     * 存储 token
     */
    public String saveToken(SecureUserToken userToken){
        String key = String.valueOf((UUID.randomUUID()));
        redisTemplate.opsForValue().set(Constant.Token.TOKEN_NAME_PREFIX+ key,userToken,Constant.Security.TOKEN_EXPIRATION, TimeUnit.SECONDS);
        return key;
    }

    /**
     * 验证 token
     */
    public SecureUserToken verifyToken(String key) throws TokenException {
        SecureUserToken secureUserToken = taskToken(key);
        if(secureUserToken ==null) throw new TokenExpiredException("token expired");
        TokenUtil.parse(secureUserToken.getToken());
        return secureUserToken;
    }

    /**
     * 获取 token
     */
    public SecureUserToken taskToken(String key){
        return redisTemplate.opsForValue().get(Constant.Token.TOKEN_NAME_PREFIX+key);
    }

    /**
     * 销毁 token
     */
    public void destroyToken(String key){
        redisTemplate.delete(Constant.Token.TOKEN_NAME_PREFIX+key);
    }

}
