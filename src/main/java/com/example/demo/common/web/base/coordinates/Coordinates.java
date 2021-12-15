package com.example.demo.common.web.base.coordinates;

import lombok.Builder;
import lombok.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/15
 */
@Data
@Builder
public class Coordinates {

    /**
     * 经度
     */
    private String j_du;

    /**
     * 纬度
     */
    private String w_du;
}
