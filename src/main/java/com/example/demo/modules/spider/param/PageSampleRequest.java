package com.example.demo.modules.spider.param;

import com.example.demo.common.web.base.page.PageRequest;
import lombok.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/14
 */
@Data
public class PageSampleRequest extends PageRequest {

    /**  搜索 */
    public String search;
}