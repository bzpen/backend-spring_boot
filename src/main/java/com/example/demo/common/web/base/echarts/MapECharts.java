package com.example.demo.common.web.base.echarts;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/15
 */
@Data
@Builder
public class MapECharts {

    /**
     * 地点名
     */
    private String name;

    /**
     * 坐标，值
     */
    private double[] value;

    /**
     * 文字位置方向
     */
    private Label label;

    /**
     * ？？
     */
    @Value("pin")
    private String symbol;

}
@Data
@Builder
class Label{

    @Value("right")
    private String position;
}
