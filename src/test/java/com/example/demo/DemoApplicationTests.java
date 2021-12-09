package com.example.demo;

import com.example.demo.modules.spider.service.SpiderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    SpiderService spiderService;

    @Test
    void contextLoads() {
        System.out.println(spiderService.gets().toString());

    }

}
