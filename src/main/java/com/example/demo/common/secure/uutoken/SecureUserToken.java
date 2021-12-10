package com.example.demo.common.secure.uutoken;

import com.example.demo.common.secure.services.SecureUser;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户 Token 封装实体
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Data
public class SecureUserToken implements Serializable {
    /**
     * Token
     */
    private String token;

    /**
     * 基本信息
     */
    private SecureUser secureUser;

}
