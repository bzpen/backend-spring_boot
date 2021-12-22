package com.example.demo.modules.spider.param;

import com.example.demo.common.web.base.page.PageRequest;
import lombok.Data;

/**
 * 用户信息分页
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/21
 */
@Data
public class PageUserRequest extends PageRequest {

    /**   搜 索  */
    private String search;
}
