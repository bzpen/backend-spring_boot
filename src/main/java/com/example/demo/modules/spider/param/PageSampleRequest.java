package com.example.demo.modules.spider.param;

import com.example.demo.common.web.base.page.PageRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/14
 */
@Data
public class PageSampleRequest extends PageRequest {

    /**   搜 索  */
    private String search;

    /**   用 户  */
    private String username;

    /** 蜘蛛名称 */
    private String name;

    /** 基因类型 */
    private String genetic;

    /**  开始时间 */
    private String startTime;

    /**  结束时间  */
    private String stopTime;
}
