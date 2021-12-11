package com.example.demo.common.email.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 邮箱实体类
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
@Data
@ApiModel("用户邮箱登录")
public class Email {
    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 验证码
     */
    private  String code;
}
