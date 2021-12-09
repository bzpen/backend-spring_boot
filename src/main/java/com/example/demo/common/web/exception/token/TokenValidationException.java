package com.example.demo.common.web.exception.token;

/**
 * token 验证异常
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public class TokenValidationException extends TokenException{
    public TokenValidationException(String message) {
        super(message);
    }
}
