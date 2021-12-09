package com.example.demo.common.web.exception.token;

import org.springframework.security.core.AuthenticationException;

/**
 * token 异常类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public class TokenException extends AuthenticationException {

    public TokenException(String message) {
        super(message);
    }
}
