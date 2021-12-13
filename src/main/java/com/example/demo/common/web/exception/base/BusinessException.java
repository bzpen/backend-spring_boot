package com.example.demo.common.web.exception.base;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/13
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
