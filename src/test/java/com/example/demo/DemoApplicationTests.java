package com.example.demo;

import com.example.demo.modules.spider.service.SpiderService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("3118659412@qq.com");
        System.out.println("==================");
        System.out.println(result);//密文
        System.out.println("==================");
    }

}
