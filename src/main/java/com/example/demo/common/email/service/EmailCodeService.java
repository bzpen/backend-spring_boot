package com.example.demo.common.email.service;

import com.example.demo.common.email.entity.Email;
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
    public Email createCode(Email email);

    /**
     * 存储 code
     */
    public Email saveCode(Email email);

    /**
     * 验证 code
     */
    public Email verifyCode(String key) throws TokenException;

    /**
     * 获取 code
     */
    public String taskCode(String key);

    /**
     * 销毁 code
     */
    public void destroyCode(String key);
}
