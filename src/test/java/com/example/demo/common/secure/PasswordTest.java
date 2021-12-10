package com.example.demo.common.secure;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Password Test
 *
 * @author Leo Wang
 * @since 2021/11/30
 */
public class PasswordTest {

    /**
     * 打印加密后密码 - 登陆密码加密
     */
    @Test
    void printPasswordEncoder() {
        String password = "123";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode(password));
    }
}
