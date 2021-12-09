package com.example.demo.modules.spider.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/21
 */
public class SpiderImgPath {

    private Spider spider;
    private List<String> img_path = new ArrayList<>();

    public Spider getSpider() {
        return spider;
    }

    public void setSpider(Spider spider) {
        this.spider = spider;
    }

    public List<String> getImg_path() {
        return img_path;
    }

    @Override
    public String toString() {
        return "ImgPaths{" +
                "spider=" + spider +
                ", img_path=" + img_path +
                '}';
    }
}
