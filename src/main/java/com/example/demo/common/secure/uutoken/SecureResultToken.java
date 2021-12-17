package com.example.demo.common.secure.uutoken;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/15
 */

@Data
@Builder
public class SecureResultToken {

    /**
     * token
     */
    private String token;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像
     */
    private String userPhoto;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 最近登录时间
     */
    private String upLoginTime;

    /**
     * 创建时间
     */
    private String registTime;

    /**
     * 创建时间
     */
    private Date createTime = new Date();
}
