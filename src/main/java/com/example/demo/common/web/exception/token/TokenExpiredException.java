package com.example.demo.common.web.exception.token;

/**
 * token 过期异常
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public class TokenExpiredException extends TokenException{

    public TokenExpiredException(String message) {
        super(message);
    }
}
