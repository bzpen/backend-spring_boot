package com.example.demo.common.secure.uutoken;

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
     * 创建时间
     */
    private Date createTime = new Date();
}
