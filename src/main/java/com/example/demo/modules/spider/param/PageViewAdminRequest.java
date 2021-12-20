package com.example.demo.modules.spider.param;

import com.example.demo.common.web.base.page.PageRequest;
import lombok.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/20
 */
@Data
public class PageViewAdminRequest extends PageRequest {

    /**   搜 索  */
    private String search;
}
