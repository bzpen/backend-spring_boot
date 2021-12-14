package com.example.demo.common.email.service;

import com.example.demo.common.email.entity.Email;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.exception.token.TokenException;

/**
 * 邮箱
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public interface EmailCodeService {

    /**
     * 创建 code
     */
    void createCode(Email email);

    /**
     * 存储 code
     */
    Email saveCode(Email email);

    /**
     * 验证 code
     */
    Email verifyCode(String key) throws TokenException;

    /**
     * 获取 code
     */
    String taskCode(String key);

    /**
     * 销毁 code
     */
    void destroyCode(String key);

    /**
     * 检查邮箱
     */
    Result check(Email email);

    /**
     * 检测验证码
     */
    Result checkCode(Email email);
}
