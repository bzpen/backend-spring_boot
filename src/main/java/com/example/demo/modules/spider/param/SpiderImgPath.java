package com.example.demo.modules.spider.param;

import com.example.demo.modules.spider.entity.TbSpider;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/24
 */
@Data
public class SpiderImgPath {

    private TbSpider spider;
    private List<String> img_path = new ArrayList<>();

}
