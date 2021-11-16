package com.example.demo.core.response;

import lombok.Getter;

/**
 * 统一返回状态码
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200,"操作成功"),

    /**
     * 失败
     */
    FAILURE(500,"操作失败");

    /**
     * 状 态 码
     */
    @Getter
    private final int code;

    /**
     * 携 带 消 息
     */
    @Getter
    private final String message;

    /**
     * 构 造 方 法
     */
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
}
