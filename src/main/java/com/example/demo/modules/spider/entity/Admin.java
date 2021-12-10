package com.example.demo.modules.spider.entity;


import lombok.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
@Data
public class Admin {

    private int id;
    private String name;
    private String number;
    private String password;
    private String head;
    private int role;

}
