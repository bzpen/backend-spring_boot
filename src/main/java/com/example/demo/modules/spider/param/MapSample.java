package com.example.demo.modules.spider.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/16
 */
@Data
@Builder
public class MapSample {

    @ApiModelProperty("采样地点")
    @TableField("locations")
    private String locations;

    @ApiModelProperty("采样精度")
    @TableField("j_du")
    private String jDu;

    @ApiModelProperty("采样纬度")
    @TableField("w_du")
    private String wDu;
}
